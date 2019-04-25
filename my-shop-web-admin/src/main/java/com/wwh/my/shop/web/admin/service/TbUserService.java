package com.wwh.my.shop.web.admin.service;

import com.wwh.my.shop.domain.TbUser;

import java.util.List;

/**
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 17:01
 */
public interface TbUserService {

    List<TbUser> selectAll();

    TbUser getById(Long id);

    List<TbUser> selectByUsername(String username);

    void insert(TbUser tbUser);

    void delete(TbUser tbUser);

    void update(TbUser tbUser);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
