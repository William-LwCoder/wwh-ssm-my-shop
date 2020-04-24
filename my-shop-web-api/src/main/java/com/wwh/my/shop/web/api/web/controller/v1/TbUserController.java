package com.wwh.my.shop.web.api.web.controller.v1;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.domain.TbUser;
import com.wwh.my.shop.web.api.service.TbUserService;
import com.wwh.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员管理
 *
 * <p>Title: TbUserController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/10/29 20:42
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser) {
        TbUser user = tbUserService.login(tbUser);
        if (user == null) {
            return BaseResult.fail("账号或密码错误");
        }

        else {
            TbUserDTO tbUserDTO = new TbUserDTO();
            BeanUtils.copyProperties(user, tbUserDTO);
            return BaseResult.success("成功", tbUserDTO);
        }
    }
}
