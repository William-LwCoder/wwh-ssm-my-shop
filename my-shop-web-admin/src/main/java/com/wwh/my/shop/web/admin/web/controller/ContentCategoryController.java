package com.wwh.my.shop.web.admin.web.controller;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.domain.TbContentCategory;
import com.wwh.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import com.wwh.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理
 *
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/4 21:55
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory, TbContentCategoryService> {

    /**
     * 所有 @RequestMapping 前执行，根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbContentCategory = service.getById(id);
        }

        else {
            tbContentCategory = new TbContentCategory();
        }

        return tbContentCategory;
    }

    /**
     * 跳转到列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @Override
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        // 排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 跳转表单页
     *
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    @Override
    public String form(TbContentCategory tbContentCategory) {
        return "content_category_form";
    }

    /**
     * 保存信息
     *
     * @param tbContentCategory
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @Override
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbContentCategory);

        // 保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_category_form";
        }

    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @Override
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            service.delete(Long.parseLong(ids));
            baseResult = BaseResult.success("删除分类及其子类及其全部内容成功");
        } else {
            baseResult = BaseResult.fail("删除分类失败");
        }

        return baseResult;
    }

    /**
     * 树形结构
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    @Override
    public List<TbContentCategory> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }
        return service.selectByPid(id);
    }
}
