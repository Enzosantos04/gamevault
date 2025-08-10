package com.gamevault.gamevault.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String email, String roles) {
}
