package com.wwh.my.shop.domain;

import com.wwh.my.shop.commons.persistence.BaseEntity;

/**
 * 内容管理
 * <p>Title: TbContent</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:41
 */
public class TbContent extends BaseEntity {

    private Long categoryId;     // 内容类目ID
    private String title;        // 内容标题
    private String subTitle;     // 子标题
    private String titleDesc;    // 标题描述
    private String url;          // 链接
    private String pic;          // 图片绝对路径
    private String pic2;         // 图片2
    private String content;      // 内容

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
