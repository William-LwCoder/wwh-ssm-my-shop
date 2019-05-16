package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    List<TbUser> selectAll();

    /**
     * 根据 id 查询用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 根据用户名进行模糊匹配
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 新增
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 删除
     * @param tbUser
     */
    void delete(TbUser tbUser);

    /**
     * 更新
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 搜索
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
     * @param param 需要两个参数 start/记录开始的位置 length/每页记录数
     * @return
     */
    List<TbUser> page(Map<String, Object> param);

    /**
     * 查询总笔数
     * @return
     */
    int count();
}
