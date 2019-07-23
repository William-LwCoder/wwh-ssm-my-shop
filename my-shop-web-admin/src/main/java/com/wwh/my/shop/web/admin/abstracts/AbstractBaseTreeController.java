package com.wwh.my.shop.web.admin.abstracts;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.persistence.BaseTreeEntity;
import com.wwh.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * <p>Title: AbstractBaseTreeController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/9 20:23
 */
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    /**
     * 跳转到列表页
     *
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     *
     * @param entity
     * @return
     */
    public abstract String form(T entity);

    /**
     * 保存信息
     *
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 树形结构
     *
     * @return
     */
    public abstract List<T> treeData(Long id);

    /**
     * 排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId 父节点的 ID
     */
    protected void sortList(List<T> sourceList, List<T> targetList, Long parentId) {
        for (T sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                // 判断有没有子节点，如果有则继续追加
                // TODO 此处逻辑和撸帝不同
                if (sourceEntity.getIsParent()) {
                    sortList(sourceList, targetList, sourceEntity.getId());

                    // Lucifer
                    /*for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(sourceList, targetList, contentCategory.getId());
                            break;
                        }
                    }*/
                }
            }
        }
    }
}
