package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.commons.persistence.BaseDao;
import com.wwh.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容分类管理
 * <p>Title: TbContentCategoryDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:51
 */
@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {

    /**
     * 根据父级节点 ID 查询所有子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
