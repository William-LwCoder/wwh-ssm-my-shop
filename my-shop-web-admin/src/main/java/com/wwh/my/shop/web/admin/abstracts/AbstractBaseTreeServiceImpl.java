package com.wwh.my.shop.web.admin.abstracts;

import com.wwh.my.shop.commons.persistence.BaseTreeDao;
import com.wwh.my.shop.commons.persistence.BaseTreeEntity;
import com.wwh.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: AbstractBaseTreeServiceImpl</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/7 22:42
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseTreeEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    /**
     * 此处为了让子类使用 dao ，因此从 private 改为 protected
     */
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
        return (T) dao.getById(id);
    }

    /**
     * 根据父级节点 ID 查询所有子节点
     *
     * @param pid
     * @return
     */
    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }
}
