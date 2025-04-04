package com.techvista.vistablog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public enum RoleEnum {

    ADMIN("admin"),
    USER("user");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

}
