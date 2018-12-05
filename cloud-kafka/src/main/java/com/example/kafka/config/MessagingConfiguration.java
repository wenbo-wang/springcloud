package com.example.kafka.config;

import com.example.kafka.kafka.ConsumerChannel;
import com.example.kafka.kafka.ProducerChannel;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = {PropertyMapper.Source.class, ProducerChannel.class, ConsumerChannel.class})
public interface MessagingConfiguration {

}