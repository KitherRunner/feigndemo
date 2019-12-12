package com.kither.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class Configure {

    @Bean
    public ConversionService webFluxConversionService() {
        return new FormattingConversionService();
    }
}
