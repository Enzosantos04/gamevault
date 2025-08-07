package com.gamevault.gamevault.mapper;

import com.gamevault.gamevault.dto.UserDTO;
import com.gamevault.gamevault.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User map(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUrl_img(dto.getUrl_img());
        user.setRoles(dto.getRoles());
        return user;
    }
   public UserDTO map(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
   }
}
