package dev.riccio.example.config.property;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@AutoConfiguration
@PropertySource("classpath:example-spring-boot-starter.properties")
public class PropertiesConfiguration {
}
