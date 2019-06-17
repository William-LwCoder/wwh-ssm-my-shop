package com.wwh.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wwh.my.shop.commons.persistence.BaseEntity;

/**
 * 内容分类管理
 * <p>Title: TbContentCategory</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:23
 */
public class TbContentCategory extends BaseEntity {

    private Long parentId;        // 父类目ID=0时，代表的是一级的类目
    private String name;          // 分类名称
    private Integer status;       // 状态。可选值:1(正常),2(删除)
    private Integer sortOrder;    // 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
    @JsonProperty(value = "isParent")
    private Boolean isParent;     // 该类目是否为父类目，1为true，0为false

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
