package com.wwh.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: TbContent</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/10/8 22:57
 */
@Data
public class TbContent implements Serializable {

    private Long id;    // 表主键 ID
//    private TbContentCategory tbContentCategory;    // 分类类目对象
    private String title;        // 内容标题
    private String subTitle;     // 子标题
    private String titleDesc;    // 标题描述
    private String url;          // 链接
    private String pic;          // 图片绝对路径
    private String pic2;         // 图片2
    private String content;      // 内容
    private Date created;   // 创建时间
    private Date updated;   // 更新时间
}
