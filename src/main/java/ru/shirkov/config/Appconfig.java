package ru.shirkov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.shirkov")
@PropertySource("classpath:application.propirties")
public class Appconfig {
}
