package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.validator.BeanValidator;
import com.wwh.my.shop.domain.TbUser;
import com.wwh.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.wwh.my.shop.web.admin.dao.TbUserDao;
import com.wwh.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * <p>Title: TbUserServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/24 17:02
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 验证通过
        else {
            tbUser.setUpdated(new Date());

            // 新增用户
            if (tbUser.getId() == null) {
                // 密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }

            // 编辑用户
            else {
                dao.update(tbUser);
            }

            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if (tbUser != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登录
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }
}
