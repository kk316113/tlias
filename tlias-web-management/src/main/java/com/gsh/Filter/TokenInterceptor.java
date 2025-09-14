package com.gsh.Filter;

import com.gsh.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //是否为登录请求
//        String requestURI = request.getRequestURI();
//        if (requestURI.contains("/login")) {
//            log.info("登录请求,放行");
//            return true;
//        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("token为空");
            response.setStatus(401);
            return false;
        }
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token解析失败");
            response.setStatus(401);
            return false;
        }
        log.info("token验证成功");
        return true;
    }
}

