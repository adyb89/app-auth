package com.adyb.backendapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.adyb.backendapp.auth.repository", "com.adyb.backendapp.core.repository"})
public class MongoConfig {}
