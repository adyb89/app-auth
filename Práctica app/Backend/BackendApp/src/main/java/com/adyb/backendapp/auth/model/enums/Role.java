package com.adyb.backendapp.auth.model.enums;

public enum Role {

	ADMIN("ADMIN_ROLE"),
	USER("USER_ROLE");
	

    private final String role;

    /**
     * @param text
     */
    Role(final String text) {
        this.role = text;
    }
    
    @Override
    public String toString() {
        return role;
    }
}
