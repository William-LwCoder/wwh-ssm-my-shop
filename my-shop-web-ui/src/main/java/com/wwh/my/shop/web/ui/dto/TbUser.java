package com.wwh.my.shop.web.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: TbUser</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/10/29 21:33
 */
@Data
public class TbUser implements Serializable {

    private String id;
    private String username;        // 用户名

    @JsonIgnore
    private String password;        // 密码，加密存储
    private String phone;           // 注册手机号
    private String email;           // 注册邮箱
    private String verification;    // 验证码
}
