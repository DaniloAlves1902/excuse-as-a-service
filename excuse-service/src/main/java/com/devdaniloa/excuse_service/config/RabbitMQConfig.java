package com.devdaniloa.excuse_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "excuse.exchange";
    public static final String QUEUE = "excuse.used.queue";
    public static final String ROUTING_KEY = "excuse.used";

    @Bean
    public TopicExchange excuseExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue excuseUsedQueue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding binding(Queue excuseUsedQueue, TopicExchange excuseExchange) {
        return BindingBuilder.bind(excuseUsedQueue).to(excuseExchange).with(ROUTING_KEY);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}