package com.gamevault.gamevault.config;

import com.gamevault.gamevault.enums.UserRole;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Builder
public record JWTUserData(Long id, String name, String email, int roles) {

    // Método para obter as authorities do usuário baseado no seu papel
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRole userRole = UserRole.values()[roles];
        if (userRole == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
}
