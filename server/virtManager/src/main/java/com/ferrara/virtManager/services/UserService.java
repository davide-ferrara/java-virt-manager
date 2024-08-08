package com.ferrara.virtManager.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ferrara.virtManager.repository.UserRepository;
import com.ferrara.virtManager.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password).orElse(null);
    }

}
