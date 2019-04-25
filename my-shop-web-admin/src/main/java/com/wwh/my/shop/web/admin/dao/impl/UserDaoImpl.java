package com.wwh.my.shop.web.admin.dao.impl;

import com.wwh.my.shop.domain.User;
import com.wwh.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: UserDaoImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:45
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        logger.debug("调用 getUser()，email:{} password:{}", email, password);

        User user = null;

        if ("admin@wwh.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setEmail("admin@wwh.com");
                user.setUsername("William");

                logger.info("成功获取 \"{}\" 的用户信息", user.getUsername());
            }
        } else {
            logger.warn("获取 \"{}\" 的用户信息失败", email);
        }

        return user;
    }
}
