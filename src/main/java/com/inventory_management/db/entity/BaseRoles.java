package com.inventory_management.db.entity;

public enum BaseRoles {
    ADMIN("ROLE_ADMIN", "ADMIN"),
    EMPLOYEE("ROLE_EMPLOYEE", "EMPLOYEE"),
    USER("ROLE_USER", "USER");
    private final String value;
    private final String role;

    private BaseRoles(String value, String role) {
        this.value = value;
        this.role = role;
    }
}
