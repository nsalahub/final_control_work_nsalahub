package com.gmail.nikolay.salahub.springbootmodule.controller.config.security.config;

import com.gmail.nikolay.salahub.springbootmodule.controller.config.security.handler.ApiAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.gmail.nikolay.salahub.springbootmodule.controller.constant.ControllerConstant.ADMINISTRATOR_ROLE_VALUE;
import static com.gmail.nikolay.salahub.springbootmodule.controller.constant.ControllerConstant.CUSTOMER_ROLE_VALUE;

@Configuration
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    @Autowired
    public ApiSecurityConfig(@Qualifier("appUserDetailsService") UserDetailsService userDetailsService,
                             PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/customer/cards")
                .hasAuthority(CUSTOMER_ROLE_VALUE)
                .antMatchers("/api/administrator/delete", "/api/administrator/add")
                .hasAuthority(ADMINISTRATOR_ROLE_VALUE)
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(apiDeniedAccessHandler())
                .and()
                .csrf()
                .disable();
    }

    @Bean("apiAccessDeniedHandler")
    AccessDeniedHandler apiDeniedAccessHandler() {
        return new ApiAccessDeniedHandler();
    }

}


