package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.domain.User;
import com.wwh.my.shop.web.admin.dao.UserDao;
import com.wwh.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
