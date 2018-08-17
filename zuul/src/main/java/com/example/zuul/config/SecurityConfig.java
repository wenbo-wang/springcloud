package com.example.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GuardProperties guardProperties;

    @Override
    public void configure(HttpSecurity http) {
        // 解决跨域问题
        http.addFilterBefore(corsFilter(), ChannelProcessingFilter.class);
    }

    @Bean
    protected CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config;
        config = guardProperties.getCors();
        System.out.println(config.getAllowedOrigins());
        if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
            source.registerCorsConfiguration("/*/v2/api-docs", config);
            source.registerCorsConfiguration("/*/api/**", config);
            source.registerCorsConfiguration("/*/management/**", config);
        }
        return new CorsFilter(source);
    }
}
