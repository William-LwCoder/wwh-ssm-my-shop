package com.wwh.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 会员数据传输对象
 *
 * <p>Title: TbUserDTO</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2020/4/21 21:43
 */
@Data
public class TbUserDTO implements Serializable {

    private String id;
    private String username;    // 用户名

    @JsonIgnore
    private String password;    // 密码，加密存储
    private String phone;       // 注册手机号
    private String email;       // 注册邮箱
}