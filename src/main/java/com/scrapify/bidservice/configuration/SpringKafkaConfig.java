package com.scrapify.bidservice.configuration;

import java.util.HashMap;
import java.util.Map;

import com.scrapify.bidservice.dto.StudentDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

//@Configuration
//@EnableKafka
public class SpringKafkaConfig {


    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,  "192.168.0.103:9092");
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.netsurfingzone.dto");
        return new DefaultKafkaProducerFactory<String, Object>(configMap);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String, StudentDTO> consumerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.103:9092");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG,"group-id");
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.scrapify.bidservice.dto");
        return new DefaultKafkaConsumerFactory<>(configMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StudentDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StudentDTO> factory = new ConcurrentKafkaListenerContainerFactory<String, StudentDTO>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
