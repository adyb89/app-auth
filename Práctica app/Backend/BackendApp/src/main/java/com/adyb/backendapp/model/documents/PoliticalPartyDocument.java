package com.adyb.backendapp.model.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Political Parties")
@Data
@NoArgsConstructor
public class PoliticalPartyDocument implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String icon;
		
	private String name;
		
	private Integer votes;
		
	private Float votesPercentage;	
	
	private Integer seats;

	public PoliticalPartyDocument(String icon, String name, Integer votes, Float votesPercentage, Integer seats) {
		this.icon = icon;
		this.name = name;
		this.votes = votes;
		this.votesPercentage = votesPercentage;
		this.seats = seats;
	}

	
}
