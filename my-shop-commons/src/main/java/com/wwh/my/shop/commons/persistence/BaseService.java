package com.wwh.my.shop.commons.persistence;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 *
 * <p>Title: BaseService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/6 12:52
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 查询表全部信息
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 保存信息
     *
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    int count(T entity);
}
