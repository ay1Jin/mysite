package com.ayjin.service.UserService;

import com.ayjin.pojo.User;

//定义一个查询用户的接口
public interface UserService {
    public User queryUserByname(String name);
}