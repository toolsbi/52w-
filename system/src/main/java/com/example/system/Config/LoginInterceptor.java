/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginInterceptor
 * Author:   tjqwecom
 * Date:     2020-10-23 19:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.system.Config;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author tjqwecom
 * @create 2020-10-23
 * @since 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session =request.getSession();
        Object username=session.getAttribute("username");
        if(username == null){
            request.getRequestDispatcher("/").forward(request,response);
            return  false;
        }
        else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}


