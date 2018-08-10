package com.example.producer.service;

import com.example.producer.domain.User;

/**
 * @author liu
 */
public interface UserService {

    /**
     * save a user
     * @param user
     * @return
     */
    User save(User user);

}
