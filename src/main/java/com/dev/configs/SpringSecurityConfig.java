/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Thanh_Tam
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.dev.controllers",
        "com.dev.repository",
        "com.dev.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception { //authorization
                http.formLogin().loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password");

                http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");

                http.exceptionHandling().accessDeniedPage("/login?accessDenied"); //Khi no khong co quyen

                http.authorizeRequests().antMatchers("/").permitAll()
                        .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
                        .antMatchers("/nurse/**").access("hasRole('ROLE_NURSE')")
                        .antMatchers("/doctor/**").access("hasRole('ROLE_DOCTOR')")
                        .antMatchers("/super-admin/**").access("hasRole('ROLE_SUPERADMIN')");

                http.logout().logoutSuccessUrl("/login");

                http.csrf().disable();  //Enable de tranh chen ma doc vao form

        }

}
