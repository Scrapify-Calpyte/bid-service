package com.scrapify.bidservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bids API", version = "1.0", description = "Bids Information"))
public class BidServiceApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//
//	public void sendMessage(String msg) {
//		kafkaTemplate.send("scrapify", msg);
//	}
	public static void main(String[] args) {
		SpringApplication.run(BidServiceApplication.class, args);
	}

//	@KafkaListener(topics = "scrapify", groupId = "group-id")
//	public void listen(String message) {
//		System.out.println("Received Messasge in group - group-id: " + message);
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		sendMessage("Hi Welcome to Spring For Apache Kafka");
//	}
}
