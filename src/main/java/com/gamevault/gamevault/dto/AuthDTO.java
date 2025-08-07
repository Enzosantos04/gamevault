package com.gamevault.gamevault.dto;

public record AuthDTO(String email, String password) {

    public AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
