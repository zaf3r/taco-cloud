package com.zaf3r.tacocloud.repository;

import com.zaf3r.tacocloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
