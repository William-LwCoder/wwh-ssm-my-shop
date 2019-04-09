package com.wwh.my.shop.service.impl;

import com.wwh.my.shop.commons.context.SpringContext;
import com.wwh.my.shop.dao.UserDao;
import com.wwh.my.shop.entity.User;
import com.wwh.my.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:16
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
