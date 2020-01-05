package com.tensquare_friend.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JwtInterceptor
 *
 * @author Paulson
 * @date 2020/1/4 3:06
 */

@Component
public class JwtInterceptor implements HandlerInterceptor{

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        // 无论如何都要放行。具体能不能操作还是再具体的操作中去判断
        // 拦截器只是负责把1请求头中包含Authorization的请求头解析
        String header = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(header) && header.startsWith("Bearer ")){
            // 如果有包含 Authorization头信息，对其进行解析
                String token = header.substring(7);

                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")){
                        request.setAttribute("claims_admin", claims);
                    }

                    if (roles != null && roles.equals("user")){
                        request.setAttribute("claims_user", claims);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确");
                }
        }
        return true;
    }
}
