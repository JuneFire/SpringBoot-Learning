package com.master.config;

import com.master.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 * 权限验证
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // Configure spring security's authenticationManager with custom
        // user details service
        auth.userDetailsService(this.userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
            http
                .authorizeRequests()
                    .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                    .and()
                    .formLogin().loginPage("/login").loginProcessingUrl("/login.do").defaultSuccessUrl("/user/info")
                    .failureUrl("/login?err=1")
                    .permitAll()
                    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll();
    }
}
