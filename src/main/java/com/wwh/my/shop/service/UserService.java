package com.wwh.my.shop.service;

import com.wwh.my.shop.entity.User;

/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:16
 */
public interface UserService {

    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User login(String email, String password);
}
