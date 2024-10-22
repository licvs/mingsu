package com.tzxy.minsu.service;

import com.tzxy.minsu.entity.User;


public interface UserService {

    User saveUser(User user);

    User findUserByUsername(String username);
}
