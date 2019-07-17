package com.wwh.my.shop.web.admin.web.controller;

import com.wwh.my.shop.commons.constant.ConstantUtils;
import com.wwh.my.shop.commons.utils.CookieUtils;
import com.wwh.my.shop.domain.TbUser;
import com.wwh.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:18
 */
@Controller
public class LoginController {

    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登录页面
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {
        String userInfo = CookieUtils.getCookieValue(httpServletRequest, COOKIE_NAME_USER_INFO);

        if (!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            httpServletRequest.setAttribute("email", userInfoArray[0]);
            httpServletRequest.setAttribute("password", userInfoArray[1]);
            httpServletRequest.setAttribute("isRemember", true);
        }

        return "login";
    }

    /**
     * 登录逻辑
     *
     * @param email
     * @param password
     * @param isRemember
     * @param httpServletRequest
     * @param httpServletResponse
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, @RequestParam(required = false) boolean isRemember, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {

        TbUser tbUser = tbUserService.login(email, password);

        // 不记住我
        if (!isRemember) {
            CookieUtils.deleteCookie(httpServletRequest, httpServletResponse, COOKIE_NAME_USER_INFO);
        }

        // 登录失败
        if (tbUser == null) {
            //httpServletRequest.setAttribute("message", "用户名或密码错误");
            model.addAttribute("message", "用户名或密码错误");
            return login(httpServletRequest);
        }

        // 登录成功
        else {
            // 将登录信息放入session
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);

            // 记住我
            if (isRemember) {
                // 用户信息存储一周
                CookieUtils.setCookie(httpServletRequest, httpServletResponse, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }

            return "redirect:/main";
        }
    }

    /**
     * 注销
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "login";
    }
}