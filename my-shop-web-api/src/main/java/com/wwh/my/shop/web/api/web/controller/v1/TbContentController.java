package com.wwh.my.shop.web.api.web.controller.v1;

import com.wwh.my.shop.commons.dto.BaseResult;
import com.wwh.my.shop.domain.TbContent;
import com.wwh.my.shop.web.api.service.TbContentService;
import com.wwh.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容管理
 *
 * <p>Title: TbContentController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/9/1 15:03
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;

        if (id == null) {
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 根据类别 ID 查询内容列表
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "{category_id}", method = RequestMethod.GET)
    public BaseResult findContentByCategoryId(@PathVariable(value = "category_id") Long categoryId) {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(categoryId);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO tbContentDTO = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, tbContentDTO);
                tbContentDTOS.add(tbContentDTO);
            }
        }

        return BaseResult.success("成功", tbContentDTOS);
    }
}
