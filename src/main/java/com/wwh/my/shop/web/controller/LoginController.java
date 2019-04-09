package com.wwh.my.shop.web.controller;

import com.wwh.my.shop.commons.context.SpringContext;
import com.wwh.my.shop.commons.utils.CookieUtils;
import com.wwh.my.shop.entity.User;
import com.wwh.my.shop.service.UserService;
import com.wwh.my.shop.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/4/8 14:18
 */
public class LoginController extends HttpServlet {

    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    private UserService userService = SpringContext.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);

        if (!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            req.setAttribute("email", userInfoArray[0]);
            req.setAttribute("password", userInfoArray[1]);
            req.setAttribute("isRemember", true);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null ? false : true;

        User admin = userService.login(email, password);

        // 不记住我
        if (!isRemember) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }

        // 登录成功
        if (admin != null) {
            // 记住我
            if (isRemember) {
                // 用户信息存储一周
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }

            resp.sendRedirect("/main.jsp");
        }

        // 登录失败
        else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}