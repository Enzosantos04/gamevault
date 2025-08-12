package com.gamevault.gamevault.service;

import com.gamevault.gamevault.dto.UserDTO;
import com.gamevault.gamevault.entity.User;
import com.gamevault.gamevault.mapper.UserMapper;
import com.gamevault.gamevault.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO register(UserDTO userDTO){
    User user = userMapper.map(userDTO);
        String encodedPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(encodedPassword));
        User savedUser = userRepository.save(user);
        return userMapper.map(savedUser);

}
}
