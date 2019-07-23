package com.wwh.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 *
 * <p>Title: BaseEntity</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/5/16 20:15
 */
@Data
public abstract class BaseEntity implements Serializable {

    private Long id;    // 表主键 ID
    private Date created;   // 创建时间
    private Date updated;   // 更新时间

}
