package com.adyb.backendapp.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import com.adyb.backendapp.auth.component.UserMapperComponentIF;
import com.adyb.backendapp.auth.exceptions.EmailAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UsernameAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UsernameAndEmailAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.constants.MessagesExceptionConstants;
import com.adyb.backendapp.auth.jwt.components.JwtProviderIF;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.model.dtos.JwtTokenDTO;
import com.adyb.backendapp.auth.model.dtos.UserLoginDTO;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;
import com.adyb.backendapp.auth.services.AuthManagerServiceIF;
import com.adyb.backendapp.auth.services.UserDAOServiceIF;
import com.adyb.backendapp.auth.services.VerifcationManagerServiceIF;

@Service
public class AuthManagerService implements AuthManagerServiceIF {

	@Autowired
	private UserDAOServiceIF userDAOService;
	
	@Autowired
	private JwtProviderIF jwtProvider;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserMapperComponentIF userMapperComponent;
	
	@Autowired
	private VerifcationManagerServiceIF verifcationManagerService;
	
	@Override
	public void registerUser(UserRegisterDTO newUser, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		else {
			UserRegisterDTO dtoenc = encryptPasswordOfUser(newUser);
			UserDocument user = userMapperComponent.fromDTOtoDocument(dtoenc);
			try {				
				userDAOService.addUser(user);
			} catch (UsernameAlreadyExistException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			} catch (EmailAlreadyExistException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			} catch (UsernameAndEmailAlreadyExistException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
			
			verifcationManagerService.startVerification(user);
		}
	
	}

	@Override
	public JwtTokenDTO login(UserLoginDTO user, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		else {
			UserDocument doc = userDAOService
					.getUserDocumentByUsername(user.getUsername());
			
			if(!BCrypt.checkpw(user.getPassword(), doc.getPassword())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessagesExceptionConstants.USER_NOT_FOUND);
			}
			
			if(!doc.getIsActived()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessagesExceptionConstants.USER_NOT_CONFIRMED);
			}
			
			Authentication auth =
					authenticationManager.authenticate(
							new UsernamePasswordAuthenticationToken(user.getUsername(), 
																	user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			JwtTokenDTO jwt = new JwtTokenDTO(jwtProvider.generateToken(auth));
			
			return jwt;
		}
		
		
	}
	
	private UserRegisterDTO encryptPasswordOfUser(UserRegisterDTO newUser) {
		
		if(newUser != null) {
			String password = newUser.getPassword();
			newUser.setPassword(bCryptPasswordEncoder.encode(password));
			
			return newUser;
		}
		
		return null;
	}

	@Override
	public JwtTokenDTO refreshToken(JwtTokenDTO jwt) {
		String token = jwt.getToken();
		JwtTokenDTO dto = new JwtTokenDTO(jwtProvider.refreshToken(token));
		return dto;
	}

	@Override
	public Boolean confirmUser(String token) {
		verifcationManagerService.activateUser(token);
		return true;
	}

}
