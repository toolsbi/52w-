///**
// * Copyright (C), 2015-2020, XXX有限公司
// * FileName: LoginInterceptorConfig
// * Author:   tjqwecom
// * Date:     2020-10-23 19:33
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.example.system.Config;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author tjqwecom
// * @create 2020-10-23
// * @since 1.0.0
// */@Configuration
////申明拦截器，实现webmvcConfig接口 不会导致静态资源被拦截
//public class LoginInterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册LoginInterceptorConfig拦截器
//        InterceptorRegistration registration=registry.addInterceptor();
//        registration.addPathPatterns("/**");
//        registration.excludePathPatterns(
//                //不拦截登录路径  ，
//                "/user/login",
//                "/",
//                "/**/*.html",
//                "/**/*.js",              //js静态资源
//                "/**/*.css",             //css静态资源
//                "/**/*.woff",
//                "/**/*.ttf"
//        );
//    }
//}
//
