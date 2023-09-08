package com.juba.springtest.config.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component(value = "coreAuthInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    @Value("${auth.token.key}")
    private String tokenKey;
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(response.SC_OK);
            return true;
        }
        else {
            try {
                final Claims claims = Jwts.parser()
                        .setSigningKey(tokenKey)
                        .parseClaimsJws(request.getHeader("Authorization"))
                        .getBody();
                request.setAttribute("SESSION_NO",claims.getId());
                request.setAttribute("USER_ID",claims.getIssuer());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.setStatus(response.SC_UNAUTHORIZED);
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
//        System.out.println("this is interceptor, postHandle method");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("this is interceptor, afterCompletion method");
    }
    
}
