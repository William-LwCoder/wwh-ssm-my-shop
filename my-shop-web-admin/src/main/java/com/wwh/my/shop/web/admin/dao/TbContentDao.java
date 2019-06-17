package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 内容管理
 * <p>Title: TbContentDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:43
 */
@Repository
public interface TbContentDao {

    /**
     * 查询全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增
     * @param tbContent
     */
    void insert(TbContent tbContent);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    TbContent getById(Long id);

    /**
     * 更新
     * @param tbContent
     */
    void update(TbContent tbContent);

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
    List<TbContent> page(Map<String, Object> param);

    /**
     * 查询总笔数
     * @param tbContent
     * @return
     */
    int count(TbContent tbContent);
}
