package com.wwh.my.shop.web.admin.service;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;
import com.wwh.my.shop.domain.TbContent;

import java.util.List;

/**
 * 内容管理
 * <p>Title: TbContentService</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:46
 */
public interface TbContentService {

    /**
     * 查询全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 保存信息
     * @param tbContent
     * @return
     */
    BaseResult save(TbContent tbContent);

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
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param tbContent
     * @return
     */
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);


    /**
     * 查询总笔数
     * @param tbContent
     * @return
     */
    int count(TbContent tbContent);
}
