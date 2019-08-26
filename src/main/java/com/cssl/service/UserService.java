package com.cssl.service;

import com.cssl.entity.User;

import java.util.List;

public interface UserService {
    //登陆
    public User LoginUser(String name, String pwd);
    //注册
    public Integer regUser(User user);
    //判断是否已经注册
    public Integer countName(String name);
}
