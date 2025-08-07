package com.gamevault.gamevault.repository;

import com.gamevault.gamevault.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
