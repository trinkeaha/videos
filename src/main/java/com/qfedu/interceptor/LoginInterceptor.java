package com.qfedu.interceptor;

import com.qfedu.entity.Admin;
import com.qfedu.entity.User;
import com.qfedu.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(request.getRequestURI());
        String uri = request.getRequestURI();
        String refer = request.getHeader("referer");
        if(request.getSession().getAttribute("admin")!=null)
            return true;
        if(uri.contains("css")||uri.contains("images")||uri.contains("js")||uri.contains("login"))
            return true;
        User user = (User)request.getSession().getAttribute(StrUtils.LOGIN_USER);

        if(user != null)
            return true;

        response.sendRedirect(refer);
        return false;
    }
}
