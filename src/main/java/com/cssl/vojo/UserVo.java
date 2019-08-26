package com.cssl.vojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserVo implements Serializable {

    private   Integer userId;
    @NotEmpty(message = "2020")
    @NotNull(message = "2020")
    private String userName;
    @NotEmpty(message = "2021")
    @NotNull(message = "2020")
    private String password;
    private Integer isAdmin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        if(isAdmin==null)
            isAdmin=0;
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        if(isAdmin==null)
            isAdmin=0;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public UserVo() {
    }

    public UserVo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserVo(String userName, String password, Integer isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserVo(Integer userId, String userName, String password, Integer isAdmin) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
