package com.krish.autodriver.configuration;

import com.krish.autodriver.converters.StringToServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ApplicationConfig {

    @Bean(name="conversionService")
    public ConversionService getConversionService() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new StringToServiceInfo());
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(converters);
        bean.afterPropertiesSet();
        return bean.getObject();
    }
}
