package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.validator.BeanValidator;
import com.wwh.my.shop.domain.TbContent;
import com.wwh.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.wwh.my.shop.web.admin.dao.TbContentDao;
import com.wwh.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>Title: TbContentServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:47
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Transactional(readOnly = false)
    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 验证通过
        else {
            tbContent.setUpdated(new Date());

            // 新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }

            // 编辑
            else {
                dao.update(tbContent);
            }

            return BaseResult.success("保存内容信息成功");
        }
    }
}
