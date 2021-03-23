package com.adyb.backendapp.test.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adyb.backendapp.auth.component.UserMapperComponentIF;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.test.factories.UserFactory;
import com.adyb.backendapp.test.utils.SystemEnvironment;

@SpringBootTest
class UserMapperComponentTest {

	@Autowired
	private UserMapperComponentIF userMapperComponent;
	
	@BeforeAll
	static void setUp() throws Exception {
		SystemEnvironment.setEnv();
	}

	@Test
	void fromDTOtoDocumentTest() {
		UserDocument doc = userMapperComponent.fromDTOtoDocument(UserFactory.generateUserRegisterDTO());
		
		assertEquals(UserFactory.generateUserDocument(), doc);
	}

}
