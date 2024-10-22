package com.tzxy.minsu.repository;

import com.tzxy.minsu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    // 这里可以添加一些自定义的数据库查询方法，如果需要的话
    User findByUsername(String username);
}
