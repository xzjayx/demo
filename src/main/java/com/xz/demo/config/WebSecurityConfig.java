package com.xz.demo.config;

import com.xz.demo.config.handle.MyAccessDeniedHandler;
import com.xz.demo.config.handle.MyPointUnauthorizedHandler;
import com.xz.demo.filter.jwt.JwtAuthorizationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;


/**
 * spring Security 配置类
 * */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Autowired
    private JwtAuthorizationTokenFilter authenticationTokenFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 由于使用的是JWT，我们这里不需要csrf
        http.csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                //  pre flight放行 配置跨域
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(HttpMethod.GET, "/**/*.jpg", "/**/*.png",
                        //swagger
                        "/swagger-ui.html", "/webjars/**", "/image/**", "/v2/api-docs/**",
                        "/swagger-resources/**", "/configuration/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/send/**").permitAll()
                //对于其他请求都要验证
                .anyRequest().authenticated();
        // 静止缓存
        http.headers().cacheControl();

       //添加filter过滤和判断token
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //配置自定义403
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new MyPointUnauthorizedHandler());
    }

}
