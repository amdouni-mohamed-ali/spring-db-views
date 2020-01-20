package com.spring.example.springdbviews.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
 * marks the class as a source of bean definitions
 */
@EnableConfigurationProperties
/*
 * this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application
 */
@ConfigurationProperties("spring.jpa.hibernate")
/*
 * binds and validates the external configurations to a configuration class
 */
public class YAMLConfig {

    private String ddlAuto;
    /*
     * will map : ddlAuto, ddl-auto or ddl_auto in the YAML file
     * check : https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
     */

    public String getDdlAuto() {
        return ddlAuto;
    }

    public void setDdlAuto(String ddlAuto) {
        this.ddlAuto = ddlAuto;
    }
}
