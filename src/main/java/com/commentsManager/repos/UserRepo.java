package com.commentsManager.repos;

import com.commentsManager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    void deleteAll();
}
