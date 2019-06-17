package com.wwh.my.shop.web.admin.service;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;
import com.wwh.my.shop.domain.TbUser;

import java.util.List;

/**
 * 用户管理
 * <p>Title: TbUserService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 17:01
 */
public interface TbUserService {

    /**
     * 查询表全部信息
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

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
     * @param tbUser
     * @return
     */
    PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser);

    /**
     * 查询总笔数
     * @param tbUser
     * @return
     */
    int count(TbUser tbUser);
}
