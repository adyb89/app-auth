package com.adyb.backendapp.core.component;

import java.util.Set;

import com.adyb.backendapp.model.documents.PoliticalPartyDocument;
import com.adyb.backendapp.model.dtos.PoliticalPartiesDTO;
import com.adyb.backendapp.model.dtos.PoliticalPartyDTO;

public interface PoliticalPartyMapperComponentIF {

	public PoliticalPartyDocument fromDTOtoDocument(PoliticalPartyDTO dto);
	
	public PoliticalPartyDTO fromDocumentToDTO(PoliticalPartyDocument document);
	
	public PoliticalPartiesDTO fromSetToDTO(Set<PoliticalPartyDTO> parties);
}
