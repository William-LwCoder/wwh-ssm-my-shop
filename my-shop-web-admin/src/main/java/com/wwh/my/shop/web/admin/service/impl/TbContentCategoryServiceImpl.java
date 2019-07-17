package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.validator.BeanValidator;
import com.wwh.my.shop.domain.TbContentCategory;
import com.wwh.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.wwh.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wwh.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>Title: TbContentCategoryServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:53
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {

    @Override
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validator = BeanValidator.validator(tbContentCategory);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 验证通过
        else {
            TbContentCategory parent = tbContentCategory.getParent();
            // 如果没有选择父级节点则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                // 0 代表根目录
                parent.setId(0L);
            }


            tbContentCategory.setUpdated(new Date());

            // 新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategory.setIsParent(false);

                // 判断当前新增的节点有没有父节点
                if (parent.getId() != 0L) {
                    TbContentCategory currentCategoryParent = dao.getById(parent.getId());
                    if (currentCategoryParent != null) {
                        // 为父级节点设置 isParent 为 true
                        currentCategoryParent.setIsParent(true);
                        dao.update(currentCategoryParent);
                    }
                }
                // 父级节点为 0 ，表示为根目录
                else {
                    // 根目录一定是父级目录
                    tbContentCategory.setIsParent(true);
                }

                dao.insert(tbContentCategory);
            }

            // 编辑
            else {
                dao.update(tbContentCategory);
            }

            return BaseResult.success("保存内容分类信息成功");
        }
    }
}
