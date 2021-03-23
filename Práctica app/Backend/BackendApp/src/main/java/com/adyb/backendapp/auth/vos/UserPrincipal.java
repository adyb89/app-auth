package com.adyb.backendapp.auth.vos;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adyb.backendapp.auth.model.document.UserDocument;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String name;
	
	private String familyName;
		
	private String email;
	
	private String password;
	
	private Boolean enabled;
	
	private List<? extends GrantedAuthority> authorities;

	public static UserPrincipal buildUser(UserDocument user) {
		List<? extends GrantedAuthority> authorities =
				user.getRoles().stream()
								.map(role -> new SimpleGrantedAuthority(role.toString()))
								.collect(Collectors.toList());
		
		return new UserPrincipal(user.getUsername(), user.getName(),
				user.getFamilyName(), user.getEmail(), user.getPassword(), user.getIsActived(), authorities);
	}
	
	
	
	public UserPrincipal(String username, String name, String familyName, String email, String password,
			Boolean enabled, List<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.name = name;
		this.familyName = familyName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {		
		return password;
	}

	@Override
	public String getUsername() {		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFamilyName() {
		return familyName;
	}



	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
}
