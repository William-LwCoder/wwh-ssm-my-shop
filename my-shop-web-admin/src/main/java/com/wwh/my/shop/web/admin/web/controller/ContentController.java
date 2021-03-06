package com.wwh.my.shop.web.admin.web.controller;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.domain.TbContent;
import com.wwh.my.shop.web.admin.abstracts.AbstractBaseController;
import com.wwh.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 内容管理
 *
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/14 23:49
 */
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent, TbContentService> {

    /**
     * 所有 @RequestMapping 前执行，根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbContent = service.getById(id);
        }

        else {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 跳转到列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @Override
    public String list() {
        return "content_list";
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    @Override
    public String form() {
        return "content_form";
    }

    /**
     * 保存信息
     *
     * @param tbContent
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @Override
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbContent);

        // 保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }

    }

    /**
     * 删除信息
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @Override
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        // 删除成功
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        // 删除失败
        else {
            baseResult = BaseResult.fail("删除失败");
        }

        return baseResult;
    }

    /**
     * 显示详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @Override
    public String detail() {
        return "content_detail";
    }
}
