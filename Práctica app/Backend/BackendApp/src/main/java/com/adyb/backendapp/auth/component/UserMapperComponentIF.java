package com.adyb.backendapp.auth.component;

import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;

public interface UserMapperComponentIF {
	
	public UserDocument fromDTOtoDocument(UserRegisterDTO dto);
	
}
