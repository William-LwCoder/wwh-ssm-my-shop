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

    public List<TbUser> selectAll();
}
