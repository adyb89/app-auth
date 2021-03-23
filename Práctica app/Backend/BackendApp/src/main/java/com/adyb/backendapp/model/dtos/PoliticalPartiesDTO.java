package com.adyb.backendapp.model.dtos;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticalPartiesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "the name field can not be null")	
	private Set<PoliticalPartyDTO> politicalParties;
}
