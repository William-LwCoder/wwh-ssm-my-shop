package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.commons.persistence.BaseDao;
import com.wwh.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 用户管理
 *
 * <p>Title: TbUserDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 16:59
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
