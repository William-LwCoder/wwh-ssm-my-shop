package com.wwh.my.shop.web.api.service;

import com.wwh.my.shop.domain.TbUser;

/**
 * 会员管理
 *
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/10/29 20:34
 */
public interface TbUserService {

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
