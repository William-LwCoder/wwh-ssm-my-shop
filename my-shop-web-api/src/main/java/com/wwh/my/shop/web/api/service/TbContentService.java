package com.wwh.my.shop.web.api.service;

import com.wwh.my.shop.domain.TbContent;

import java.util.List;

/**
 * 内容管理
 *
 * <p>Title: TbContentService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/9/1 14:57
 */
public interface TbContentService {

    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
