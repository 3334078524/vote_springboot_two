package com.cssl.service.impl;

import com.cssl.entity.User;
import com.cssl.mapper.UserMapper;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public User LoginUser(String name, String pwd) {
        return userMapper.LoginUser(name, pwd);
    }

    @Override
    public Integer regUser(User user) {
        return userMapper.regUser(user);
    }

    @Override
    public Integer countName(String name) {
        Integer integer = userMapper.CountName(name);
        System.out.println("----------------------user"+name);
        System.out.println("-----------------index"+integer);
        return integer;
    }
}
