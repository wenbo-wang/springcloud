package com.example.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    private final KafkaTopicProperties properties;

    public KafkaTopicConfiguration(KafkaTopicProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "topics")
    public String[] kafkaTopicName() {
        return properties.getTopicName();
    }

    @Bean(name = "groups")
    public String topicGroupId() {
        return properties.getGroupId();
    }

}