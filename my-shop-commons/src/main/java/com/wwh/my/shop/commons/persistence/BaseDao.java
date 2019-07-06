package com.wwh.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 * <p>Title: BaseDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/6 12:46
 */
public interface BaseDao<T extends BaseEntity> {

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
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param param 需要两个参数 start/记录开始的位置 length/每页记录数
     * @return
     */
    List<T> page(Map<String, Object> param);

    /**
     * 查询总笔数
     * @param entity
     * @return
     */
    int count(T entity);
}
