package com.adyb.backendapp.test.factories;

import com.adyb.backendapp.model.documents.PoliticalPartyDocument;
import com.adyb.backendapp.model.dtos.PoliticalPartyDTO;

public class PoliticalPartyFactory {

	public static PoliticalPartyDTO generatePoliticalPartyDTO() {
		return new PoliticalPartyDTO("", "", 0, 0.0f, 0);
	}
	
	public static PoliticalPartyDocument generatePoliticalPartyDocument() {
		return new PoliticalPartyDocument("", "", 0, 0.0f, 0);
	}
}
