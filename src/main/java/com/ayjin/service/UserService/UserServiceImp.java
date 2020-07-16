package com.ayjin.service.UserService;

import com.ayjin.mapper.UserMapper;
import com.ayjin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByname(String name) {
        return userMapper.queryUserByName(name);
    }
}
