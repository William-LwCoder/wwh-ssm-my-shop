package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.validator.BeanValidator;
import com.wwh.my.shop.domain.TbContentCategory;
import com.wwh.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wwh.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: TbContentCategoryServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:53
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validator = BeanValidator.validator(tbContentCategory);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 验证通过
        else {
            tbContentCategory.setUpdated(new Date());

            // 新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategoryDao.insert(tbContentCategory);
            }

            // 编辑
            else {
                tbContentCategoryDao.update(tbContentCategory);
            }

            return BaseResult.success("保存内容分类信息成功");
        }
    }
}
