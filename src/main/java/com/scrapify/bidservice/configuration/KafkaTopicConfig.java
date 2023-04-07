package com.scrapify.bidservice.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.103:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic scrapifyTopic(){
        return TopicBuilder.name("scrapify")
                .build();
    }
}
