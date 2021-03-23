package com.adyb.backendapp.model.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticalPartyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String icon;
	
	@NotNull(message = "the name field can not be null")
	@NotEmpty(message = "the name field can not be empty")
	private String name;
	
	@NotNull(message = "the votes field can not be null")	
	@Positive
	private Integer votes;
	
	@NotNull(message = "the votes percentage field can not be null")
	@Positive
	private Float votesPercentage;	
	
	@NotNull(message = "the seats field can not be null")	
	@Positive
	private Integer seats;
		
}
