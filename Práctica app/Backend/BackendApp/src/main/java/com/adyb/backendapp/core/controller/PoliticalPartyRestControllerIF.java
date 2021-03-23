package com.adyb.backendapp.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adyb.backendapp.constants.CommonConstants;
import com.adyb.backendapp.core.constants.ApiUriApp;
import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;

@CrossOrigin(CommonConstants.URI_FRONTEND)
@RequestMapping(ApiUriApp.API_BASE)
public interface PoliticalPartyRestControllerIF {

	@GetMapping(ApiUriApp.PARTIES)
	public ResponseEntity<PoliticalPartiesDTO> getPoliticalParties();
}
