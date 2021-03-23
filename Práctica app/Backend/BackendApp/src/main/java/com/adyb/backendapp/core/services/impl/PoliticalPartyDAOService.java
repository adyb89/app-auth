package com.adyb.backendapp.core.services.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.core.component.PoliticalPartyMapperComponentIF;
import com.adyb.backendapp.core.repository.PoliticalPartyRepository;
import com.adyb.backendapp.core.services.PoliticalPartyDAOServiceIF;
import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;
import com.adyb.backendapp.model.dtos.PoliticalPartyDTO;

@Service
public class PoliticalPartyDAOService implements PoliticalPartyDAOServiceIF {

	@Autowired
	private PoliticalPartyMapperComponentIF politicalPartyMapperComponent;
	
	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;
	
	@Override
	public PoliticalPartiesDTO getAll() {
		Set<PoliticalPartyDTO> parties =
				politicalPartyRepository.findAll()
										.stream()
										.map(doc -> politicalPartyMapperComponent.fromDocumentToDTO(doc))
										.collect(Collectors.toSet());
										
		return new PoliticalPartiesDTO(parties);
	}

}
