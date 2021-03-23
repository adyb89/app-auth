package com.adyb.backendapp.core.component.impl;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.adyb.backendapp.core.component.PoliticalPartyMapperComponentIF;
import com.adyb.backendapp.model.documents.PoliticalPartyDocument;
import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;
import com.adyb.backendapp.model.dtos.PoliticalPartyDTO;

@Component
public class PoliticalPartyMapperComponent implements PoliticalPartyMapperComponentIF {
		

	@Override
	public PoliticalPartyDocument fromDTOtoDocument(PoliticalPartyDTO dto) {
		PoliticalPartyDocument doc = null;
		
		if(dto != null) {
			doc = new PoliticalPartyDocument(dto.getIcon(), dto.getName(), 
					dto.getVotes(), dto.getVotesPercentage(), dto.getSeats());
		}
		
		return doc;
		
	}

	@Override
	public PoliticalPartyDTO fromDocumentToDTO(PoliticalPartyDocument document) {
		PoliticalPartyDTO dto = null;
		
		if(document != null) {
			dto = new PoliticalPartyDTO(document.getIcon(), document.getName(), 
					document.getVotes(), document.getVotesPercentage(), document.getSeats());
		}
		
		return dto;
	}
	
	@Override
	public PoliticalPartiesDTO fromSetToDTO(Set<PoliticalPartyDTO> parties) {
		return new PoliticalPartiesDTO(parties);
	}

}
