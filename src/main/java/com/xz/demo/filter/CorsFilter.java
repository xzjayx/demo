package com.xz.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域的支持配置
 * 跨域发出两次请求
 * 第一次发送的就是preflight request(预检请求)。  Origin  所以security里面要排除
 * @author xz
 * */
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;

        HttpServletRequest reqs = (HttpServletRequest) req;

        response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));
        //允许跨域访问的域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //允许使用的请求方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, x-requested-with,Cache-Control,Pragma,Content-Type,Authorization");
        //是否允许请求带有验证信息
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(req, res);
    }



    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
