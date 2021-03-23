package com.adyb.backendapp.core.services;

import org.springframework.transaction.annotation.Transactional;

import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;

public interface PoliticalPartyDAOServiceIF {

	@Transactional
	public PoliticalPartiesDTO getAll();
	
}
