package com.adyb.backendapp.core.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.adyb.backendapp.core.controller.PoliticalPartyRestControllerIF;
import com.adyb.backendapp.core.services.PoliticalPartyDAOServiceIF;
import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;

@RestController
public class PoliticalPartyRestController implements PoliticalPartyRestControllerIF {
	
	@Autowired
	private PoliticalPartyDAOServiceIF politicalPartyDAOService;

	@Override
	public ResponseEntity<PoliticalPartiesDTO> getPoliticalParties() {
		return ResponseEntity.ok(politicalPartyDAOService.getAll());
	}

}
