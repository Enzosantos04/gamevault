package com.gamevault.gamevault.dto;

public record TokenDTO(String token) {

    public TokenDTO(String token) {
        this.token = token;
    }

}
