package com.wwh.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wwh.my.shop.commons.persistence.BaseEntity;
import com.wwh.my.shop.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * 用户管理
 * <p>Title: TbUser</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 16:50
 */
@Data
public class TbUser extends BaseEntity {

    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String username;    // 用户名

    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;    // 密码，加密存储

    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;       // 注册手机号

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;       // 注册邮箱
}
