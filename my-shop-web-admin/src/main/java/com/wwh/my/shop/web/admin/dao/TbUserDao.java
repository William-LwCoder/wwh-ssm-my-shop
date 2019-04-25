package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title: TbUserDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 16:59
 */
@Repository
public interface TbUserDao {

    /**
     * 查询表全部信息
     * @return
     */
    public List<TbUser> selectAll();
}
