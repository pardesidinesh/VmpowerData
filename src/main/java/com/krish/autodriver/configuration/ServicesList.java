package com.krish.autodriver.configuration;

import com.krish.autodriver.entity.http.ServiceInfo;
import com.krish.autodriver.factory.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:static/service-info.yml", factory = YamlPropertySourceFactory.class)
public class ServicesList {
    private @Getter @Setter String name;
    private @Getter @Setter List<ServiceInfo> services;
}
