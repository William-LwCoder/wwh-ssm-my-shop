package com.wwh.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: BaseTreeEntity</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/9 20:38
 */
@Data
public abstract class BaseTreeEntity<T extends BaseTreeEntity> extends BaseEntity implements Serializable {

    private T parent;    // 父类类目对象 父类目ID=0时，代表的是一级的类目
    private Boolean isParent;     // 该类目是否为父类目，1为true，0为false

}
