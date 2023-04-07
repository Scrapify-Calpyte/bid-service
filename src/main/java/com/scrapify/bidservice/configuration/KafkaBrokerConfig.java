package com.scrapify.bidservice.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableKafka
public class KafkaBrokerConfig {
    @Value("${kafka.broker.id}")
    private int brokerId;

    @Value("${kafka.listeners}")
    private String listeners;

    @Value("${kafka.log.dirs}")
    private String logDirs;

    @Value("${kafka.num.network.threads}")
    private int numNetworkThreads;

    @Value("${kafka.num.io.threads}")
    private int numIoThreads;

    @Value("${kafka.log.retention.hours}")
    private int logRetentionHours;

    @Value("${kafka.default.replication.factor}")
    private short defaultReplicationFactor;

    @Value("${kafka.min.insync.replicas}")
    private int minInSyncReplicas;

    // Define Kafka broker properties
    public Map<String, Object> brokerProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("broker.id", brokerId);
        props.put("listeners", listeners);
        props.put("log.dirs", logDirs);
        props.put("num.network.threads", numNetworkThreads);
        props.put("num.io.threads", numIoThreads);
        props.put("log.retention.hours", logRetentionHours);
        props.put("default.replication.factor", defaultReplicationFactor);
        props.put("min.insync.replicas", minInSyncReplicas);
        return props;
    }
}
