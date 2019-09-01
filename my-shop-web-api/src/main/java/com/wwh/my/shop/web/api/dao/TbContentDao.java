package com.wwh.my.shop.web.api.dao;

import com.wwh.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容管理
 *
 * <p>Title: TbContentDao</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/9/1 14:44
 */
@Repository
public interface TbContentDao {

    /**
     * 根据类别 ID 查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
