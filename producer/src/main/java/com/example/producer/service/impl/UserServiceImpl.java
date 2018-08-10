package com.example.producer.service.impl;

import com.example.producer.domain.User;
import com.example.producer.repository.UserRepository;
import com.example.producer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @program: springboot
 * @description: user service
 * @author: liujc
 * @create: 2018-06-14 15:28
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    /**
     * save a user
     *
     * @param user
     * @return
     */

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
