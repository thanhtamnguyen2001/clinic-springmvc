/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Thanh_Tam
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() { //cho biet co cau minh nao trong project
                return new Class[]{
                        HibernateConfig.class,
                        TilesConfig.class  ,
                        SpringSecurityConfig.class
                };
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
                return new Class[]{
                        WebApplicationContextConfig.class
                };
        }

        @Override
        protected String[] getServletMappings() {
                return new String[]{"/"};
        }
}
