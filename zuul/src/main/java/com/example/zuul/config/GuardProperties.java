package com.example.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

// 对应配置文件
@ConfigurationProperties(prefix = "guard", ignoreUnknownFields = false)
public class GuardProperties {

    private CorsConfiguration cors = new CorsConfiguration();

    public void setCors(CorsConfiguration cors) {
        this.cors = cors;
    }

    public CorsConfiguration getCors() {
        return cors;
    }

    @Override
    public String toString() {
        return "GuardProperties{" +
                "cors=" + cors +
                '}';
    }
}
