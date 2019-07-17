package com.wwh.my.shop.web.admin.abstracts;

import com.wwh.my.shop.commons.dto.PageInfo;
import com.wwh.my.shop.commons.persistence.BaseDao;
import com.wwh.my.shop.commons.persistence.BaseEntity;
import com.wwh.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: AbstractBaseServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/8 19:52
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询表全部信息
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除信息
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        PageInfo<T> pageInfo = new PageInfo<>();
        Map<String, Object> param = new HashMap<>();
        param.put("start", start);
        param.put("length", length);
        param.put("pageParams", entity);
        int count = dao.count(entity);

        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(param));
        pageInfo.setError("");

        return pageInfo;
    }

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }
}
