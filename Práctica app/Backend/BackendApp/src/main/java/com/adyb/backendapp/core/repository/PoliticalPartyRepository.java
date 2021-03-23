package com.adyb.backendapp.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adyb.backendapp.model.documents.PoliticalPartyDocument;

@Repository
public interface PoliticalPartyRepository extends MongoRepository<PoliticalPartyDocument, Long> {

}
