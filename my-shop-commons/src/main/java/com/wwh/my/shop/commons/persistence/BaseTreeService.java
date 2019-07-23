package com.wwh.my.shop.commons.persistence;

import com.wwh.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用的树形机构接口
 *
 * <p>Title: BaseTreeService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/7 22:25
 */
public interface BaseTreeService<T extends BaseTreeEntity> {

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
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
