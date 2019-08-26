package com.cssl.mapper;

import com.cssl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    //登陆
    User LoginUser(@Param("userName")String userName,@Param("password")String password);
    //注册
    Integer regUser(User user);
    //判断是否已经登陆
    Integer CountName(@Param("userName")String userName);
}
