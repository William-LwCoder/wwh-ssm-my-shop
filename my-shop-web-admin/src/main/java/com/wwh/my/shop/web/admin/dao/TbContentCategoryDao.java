package com.wwh.my.shop.web.admin.dao;

import com.wwh.my.shop.commons.persistence.BaseTreeDao;
import com.wwh.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

/**
 * 内容分类管理
 *
 * <p>Title: TbContentCategoryDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:51
 */
@Repository
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {

}
