package com.wwh.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wwh.my.shop.commons.persistence.BaseEntity;

/**
 * 用户管理
 * <p>Title: TbUser</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 16:50
 */
public class TbUser extends BaseEntity {

    private String username;    // 用户名
    private String password;    // 密码，加密存储
    private String phone;       // 注册手机号
    private String email;       // 注册邮箱

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
