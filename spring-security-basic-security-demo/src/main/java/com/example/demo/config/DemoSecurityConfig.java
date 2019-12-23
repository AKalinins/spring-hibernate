package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("John").password("john123").roles("EMPLOYEE"))
                .withUser(users.username("Mary").password("mary123").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("Mike").password("mike123").roles("EMPLOYEE", "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/").hasRole("EMPLOYEE")
                    .antMatchers("/management/**").hasRole("MANAGER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access-denied");
    }
}
