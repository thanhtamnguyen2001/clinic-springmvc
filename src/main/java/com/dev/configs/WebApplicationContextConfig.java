/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dev.formatters.MedicalCertificateFormatter;
import com.dev.formatters.MedicalRegisterFormatter;
import com.dev.formatters.MedicineFormatter;
import com.dev.formatters.PrescriptionFormatter;
import com.dev.formatters.RegulationFormatter;
import com.dev.formatters.UnitFormatter;
import com.dev.formatters.UserFormatter;
import com.dev.formatters.UserRoleFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Thanh_Tam
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.dev.controllers",
    "com.dev.repository",
    "com.dev.service"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
    }
    
    //MessageSource chỉ ra nơi chứa các properties để nạp lên
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");
        return m;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }

//        @Bean
//        public InternalResourceViewResolver viewResolver() {
//                InternalResourceViewResolver r = new InternalResourceViewResolver();
//                r.setPrefix("/WEB-INF/jsp/");
//                r.setSuffix(".jsp");
//                r.setViewClass(JstlView.class);
//
//                return r;
//        }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "tamdev",
                        "api_key", "635282354212715",
                        "api_secret", "Xl4NcJeU9936fRWWaYP0LzyeT1M",
                        "secure", true));
        return cloudinary;
    }
    
    //Các mối quan hệ n-1, n-n thường phải có formatter
    @Override
    public void addFormatters(FormatterRegistry r) {
        r.addFormatter(new UnitFormatter());
        r.addFormatter(new UserFormatter());
        r.addFormatter(new MedicalCertificateFormatter());
        r.addFormatter(new PrescriptionFormatter());
        r.addFormatter(new MedicineFormatter());
        r.addFormatter(new RegulationFormatter());
        r.addFormatter(new MedicalRegisterFormatter());
        r.addFormatter(new UserRoleFormatter());
    }
}
