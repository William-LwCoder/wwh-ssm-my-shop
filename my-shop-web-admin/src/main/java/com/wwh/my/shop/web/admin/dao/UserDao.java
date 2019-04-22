package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.domain.User;

/**
 * <p>Title: UserDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:45
 */
public interface UserDao {

    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User getUser(String email, String password);
}
