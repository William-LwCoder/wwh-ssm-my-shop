package com.wwh.my.shop.domain;

import java.io.Serializable;

/**
 * <p>Title: User</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:46
 */
public class User implements Serializable {
    private String username;
    private String email;
    private String password;

    // 记住我
    private String isRemember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsRemember() {
        return isRemember;
    }

    public void setIsRemember(String isRemember) {
        this.isRemember = isRemember;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isRemember='" + isRemember + '\'' +
                '}';
    }
}
