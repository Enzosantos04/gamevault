package com.gamevault.gamevault.controller;


import com.gamevault.gamevault.dto.UserDTO;
import com.gamevault.gamevault.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamevault/auth")
public class AuthController {


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(UserDTO userDTO) {
        UserDTO savedUser = userService.register(userDTO);
        return ResponseEntity.ok(userDTO);
    }
}
