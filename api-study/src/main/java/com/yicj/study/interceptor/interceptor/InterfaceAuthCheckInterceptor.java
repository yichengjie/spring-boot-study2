package com.yicj.study.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//微服务间接口访问密匙验证
@Slf4j
public class InterfaceAuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = request.getParameter("key") ;
        if(key == null || key.trim().length() == 0){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("非法访问！");
            return false;
        }else{
            log.info("test redis import :" );
            // TODO 验证逻辑
            return true;
        }
    }
}
