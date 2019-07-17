package com.wwh.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title: MainController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/11 19:35
 */
@Controller
public class MainController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
