package com.wwh.my.shop.domain;

import com.wwh.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 内容管理
 * <p>Title: TbContent</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:41
 */
@Data
public class TbContent extends BaseEntity {

    @NotNull(message = "所属分类不能为空")
    private TbContentCategory tbContentCategory;    // 分类类目对象

    @Length(min = 1, max = 20, message = "标题长度介于 1 - 20 个字符之间")
    private String title;        // 内容标题

    @Length(min = 1, max = 20, message = "子标题长度介于 1 - 20 个字符之间")
    private String subTitle;     // 子标题

    @Length(min = 1, max = 50, message = "标题描述长度介于 1 - 50 个字符之间")
    private String titleDesc;    // 标题描述

    private String url;          // 链接
    private String pic;          // 图片绝对路径
    private String pic2;         // 图片2

    @Length(min = 1, message = "内容不能为空")
    private String content;      // 内容
}
