package com.wwh.my.shop.web.ui.interceptor;

import com.wwh.my.shop.web.ui.constant.SystemConstants;
import com.wwh.my.shop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2020/4/21 22:25
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);

        // 未登录状态
        if (tbUser == null) {
            return true;
        }

        // 已登录状态
        else {
            httpServletResponse.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
