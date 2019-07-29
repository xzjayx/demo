package com.xz.demo.filter.jwt;

import com.xz.demo.config.Constant;
import com.xz.demo.util.JwtUtil;
import com.xz.demo.util.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * jwt的过滤类
 * @author xiezhi
 * */
@Slf4j
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {


    private final RedisUtil redisUtil;

    @Value("${jwt.header}")
    private String head;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public JwtAuthorizationTokenFilter(RedisUtil redisUtil, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.redisUtil = redisUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String token = request.getHeader(this.head);
        if (token != null && token.startsWith(tokenHead)) {
            final String authToken = token.substring(tokenHead.length());
            Claims claims = null ;
            try {
                  claims = JwtUtil.parseJWT(authToken);
            }catch(ExpiredJwtException expiredJwtException){
                request.getRequestDispatcher(Constant.EXCEPTION_URL.concat("403")).forward(request, response);
                return;
            }
            if(Objects.isNull(claims)){
                request.getRequestDispatcher(Constant.EXCEPTION_URL.concat("401")).forward(request, response);
                return;
            }
            String username = claims.getSubject();
            log.info("checking authentication :{}", username);

            if(Objects.isNull(redisUtil.get(username))){
               //redis 取值不到说明 token 失效，需要重新获取
                request.getRequestDispatcher(Constant.EXCEPTION_URL.concat("403")).forward(request, response);
                return;
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //可有自己进行每个URL的粒度控制，也可以用spring security 进行上下文控制
                request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
