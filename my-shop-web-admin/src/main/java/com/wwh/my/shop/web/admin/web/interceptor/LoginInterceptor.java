package com.wwh.my.shop.web.admin.web.interceptor;

import com.wwh.my.shop.commons.constant.ConstantUtils;
import com.wwh.my.shop.domain.TbUser;
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
 * @date 2019/4/11 19:58
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        // 未登录
        if (tbUser == null) {
            httpServletResponse.sendRedirect("/login");
        }


        // 放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
