package com.young.securitydemo.config;

import com.young.securitydemo.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;//无权限登录
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;//认证失败

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                /**禁用csrf*/
                .csrf().disable()
                /**授权异常**/
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                /**防止iframe造成的跨域*/
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                //静态资源放行
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**"
                ).permitAll()
                //放行swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                //文件放行
                .antMatchers("/file/**").permitAll()
                //druid放行
                .antMatchers("/druid/**").permitAll()
                //options的所有请求放行
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //允许匿名以及登录用户访问
                .antMatchers("api/auth/**", "/error/**").permitAll()
                //所有请求都需要认证
                .anyRequest().authenticated();

        //禁用缓存
        http.headers().cacheControl();
        //添加jwt filter
        http.apply(new TokenConfig(jwtTokenUtil));
    }

    public class TokenConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

        private final JwtTokenUtil jwtTokenUtil;

        public TokenConfig(JwtTokenUtil jwtTokenUtil) {
            this.jwtTokenUtil = jwtTokenUtil;
        }

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            JwtTokenFilter filter = new JwtTokenFilter();
            builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        }
    }
}
