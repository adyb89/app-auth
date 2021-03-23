package com.adyb.backendapp.auth.model.document;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Verification tokens")
@Data
public class VerificationTokenDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String token;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime expiredAt;
	
	private LocalDateTime confirmedAt;
	
	private String username;

	public VerificationTokenDocument(String token, LocalDateTime createdAt, LocalDateTime expiredAt, String username) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.username = username;
	}
	
	public boolean isExpired() {
		return expiredAt.isEqual(LocalDateTime.now())
				|| LocalDateTime.now().isAfter(expiredAt);
	}
}
