package com.wwh.my.shop.domain;

import com.wwh.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 内容分类管理
 * <p>Title: TbContentCategory</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:23
 */
@Data
public class TbContentCategory extends BaseEntity {

    @NotBlank
    private Long parentId;        // 父类目ID=0时，代表的是一级的类目

    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;          // 分类名称

    private Integer status;       // 状态。可选值:1(正常),2(删除)

    @NotNull(message = "排序不能为空")
    private Integer sortOrder;    // 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    private Boolean isParent;     // 该类目是否为父类目，1为true，0为false
}
