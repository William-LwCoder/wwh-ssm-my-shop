package com.wwh.my.shop.web.admin.service.impl;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;
import com.wwh.my.shop.commons.utils.RegexpUtils;
import com.wwh.my.shop.commons.validator.BeanValidator;
import com.wwh.my.shop.domain.TbContent;
import com.wwh.my.shop.web.admin.dao.TbContentDao;
import com.wwh.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: TbContentServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:47
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;


    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

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
                tbContentDao.insert(tbContent);
            }

            // 编辑
            else {
                tbContentDao.update(tbContent);
            }

            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        PageInfo<TbContent> pageInfo = new PageInfo<>();
        Map<String, Object> param = new HashMap<>();
        param.put("start", start);
        param.put("length", length);
        param.put("tbContent", tbContent);
        int count = tbContentDao.count(tbContent);

        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(param));
        pageInfo.setError("");

        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }
}
