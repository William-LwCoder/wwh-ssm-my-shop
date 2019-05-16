package com.wwh.my.shop.web.admin.service;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;
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

    BaseResult save(TbUser tbUser);

    void delete(TbUser tbUser);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @return
     */
    PageInfo<TbUser> page(int start, int length, int draw);

    /**
     * 查询总笔数
     * @return
     */
    int count();
}
