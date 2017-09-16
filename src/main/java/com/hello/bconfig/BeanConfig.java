package com.hello.bconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class BeanConfig {
    @Bean
    public MethodValidationPostProcessor getMethodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
