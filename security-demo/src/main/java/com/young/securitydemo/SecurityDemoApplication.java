package com.young.securitydemo;

import com.young.securitydemo.config.JwtTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean registrationBean(JwtTokenFilter jwtTokenFilter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(jwtTokenFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }
}
