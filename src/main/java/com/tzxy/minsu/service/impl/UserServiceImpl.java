package com.tzxy.minsu.service.impl;

import com.tzxy.minsu.entity.User;
import com.tzxy.minsu.repository.UserRepository;
import com.tzxy.minsu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        // 这里添加通过用户名查找用户的逻辑
        return userRepository.findByUsername(username);
    }
}
