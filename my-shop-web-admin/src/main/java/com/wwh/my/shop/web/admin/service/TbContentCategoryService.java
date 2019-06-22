package com.wwh.my.shop.web.admin.service;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.domain.TbContentCategory;

import java.util.List;

/**
 * 内容分类管理
 * <p>Title: TbContentCategoryService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:52
 */
public interface TbContentCategoryService {

    /**
     * 查询表全部信息
     * @return
     */
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点 ID 查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);

    /**
     * 根据 id 查询信息
     * @param id
     * @return
     */
    TbContentCategory getById(Long id);

    /**
     * 保存信息
     * @param tbContentCategory
     * @return
     */
    BaseResult save(TbContentCategory tbContentCategory);
}
