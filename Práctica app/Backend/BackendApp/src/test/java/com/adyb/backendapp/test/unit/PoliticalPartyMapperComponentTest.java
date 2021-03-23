package com.adyb.backendapp.test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adyb.backendapp.core.component.PoliticalPartyMapperComponentIF;
import com.adyb.backendapp.model.documents.PoliticalPartyDocument;
import com.adyb.backendapp.model.dtos.PoliticalPartyDTO;
import com.adyb.backendapp.test.factories.PoliticalPartyFactory;
import com.adyb.backendapp.test.utils.SystemEnvironment;

@SpringBootTest
class PoliticalPartyMapperComponentTest {

	@Autowired
	private PoliticalPartyMapperComponentIF politicalPartyMapperComponent;
	
	@BeforeAll
	public static void setUp() {
		SystemEnvironment.setEnv();
	}
	
	@Test
	void fromDTOtoDocumentTest() {
		PoliticalPartyDocument doc = politicalPartyMapperComponent
				.fromDTOtoDocument(PoliticalPartyFactory.generatePoliticalPartyDTO());
		
		assertEquals(PoliticalPartyFactory.generatePoliticalPartyDocument(), doc);
	}

	@Test
	void fromDocumentToDTOTest() {
		PoliticalPartyDTO dto = politicalPartyMapperComponent
				.fromDocumentToDTO(PoliticalPartyFactory.generatePoliticalPartyDocument());
		
		assertEquals(PoliticalPartyFactory.generatePoliticalPartyDTO(), dto);
				
	}
}
