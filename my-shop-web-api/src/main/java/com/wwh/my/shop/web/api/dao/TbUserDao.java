package com.wwh.my.shop.web.api.dao;

import com.wwh.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 *
 * <p>Title: TbUserDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/10/29 20:25
 */
@Repository
public interface TbUserDao {

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
