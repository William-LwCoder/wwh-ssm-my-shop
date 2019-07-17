package com.wwh.my.shop.commons.persistence;

import java.util.List;

/**
 * 通用的树形机构接口
 *
 * <p>Title: BaseTreeDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/7 22:19
 */
public interface BaseTreeDao<T extends BaseTreeEntity> {

    /**
     * 查询表全部信息
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 查询信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点 ID 查询所有子节点
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
