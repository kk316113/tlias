package com.gsh.Filter;

import com.gsh.utils.CurrentHolder;
import com.gsh.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebFilter("/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //是否为登录请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login")) {
            log.info("登录请求,放行");
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("token为空");
            response.setStatus(401);
            return;
        }
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前用户id为：{}存入ThreadLocal", empId);
        } catch (Exception e) {
            log.info("token解析失败");
            response.setStatus(401);
            return;
        }
        log.info("token验证成功");
        filterChain.doFilter(request, response);
        CurrentHolder.remove();
    }
}
