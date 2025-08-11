package com.gamevault.gamevault.config;

import lombok.Builder;

@Builder

public record JWTUserData(Long id, String name, String email, String roles) {
}
