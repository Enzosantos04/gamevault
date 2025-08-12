package com.gamevault.gamevault.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gamevault.gamevault.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("JWT_KEY")
    String secret;
    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("UserId", user.getId())
                .withClaim("name", user.getName())
                .withClaim("roles", user.getRoles().ordinal())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("GameVault")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);
            return Optional.of(JWTUserData
                    .builder()
                    .id(jwt.getClaim("UserId").asLong())
                    .name(jwt.getClaim("name").asString())
                    .email(jwt.getSubject())
                    .roles(jwt.getClaim("roles").asString())
            .build());
        }catch (JWTVerificationException exception){
            return Optional.empty();
        }
    }

}
