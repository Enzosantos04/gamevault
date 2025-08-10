package com.gamevault.gamevault.controller;


import com.gamevault.gamevault.config.TokenService;
import com.gamevault.gamevault.dto.AuthDTO;
import com.gamevault.gamevault.dto.UserDTO;
import com.gamevault.gamevault.entity.User;
import com.gamevault.gamevault.service.UserService;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gamevault/auth")
public class  AuthController {


    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(UserDTO userDTO) {
        UserDTO savedUser = userService.register(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken userAndPassword =
                new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        Authentication authentication = authenticationManager.authenticate(userAndPassword);
        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(token);
    }
}
