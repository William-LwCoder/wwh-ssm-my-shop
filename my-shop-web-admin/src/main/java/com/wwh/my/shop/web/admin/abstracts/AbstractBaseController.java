package com.wwh.my.shop.web.admin.abstracts;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.commons.dto.PageInfo;
import com.wwh.my.shop.commons.persistence.BaseEntity;
import com.wwh.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: AbstractBaseController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/7/8 23:16
 */
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    /**
     * 跳转到列表页
     *
     * @return
     */
    public abstract String list();

    /**
     * 跳转表单页
     *
     * @return
     */
    public abstract String form();

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
     * 删除信息
     *
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 分页查询
     *
     * @param request
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<T> page(HttpServletRequest request, T entity) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<T> pageInfo = service.page(start, length, draw, entity);

        return pageInfo;
    }

    /**
     * 显示详情
     *
     * @return
     */
    public abstract String detail();
}
