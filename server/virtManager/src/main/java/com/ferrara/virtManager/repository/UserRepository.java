package com.ferrara.virtManager.repository;

import com.ferrara.virtManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
}
