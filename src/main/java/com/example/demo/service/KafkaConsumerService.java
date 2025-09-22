package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.productor.avro.SimpleMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumerService {

	@KafkaListener(topics = "${app.config.topic-name}", groupId = "${app.config.grooup-id}")
	public void listen(ConsumerRecord<String, SimpleMessage> message) {
		
		log.info("offset: {}", message.offset());
		log.info("key: {}", message.key());
		
		SimpleMessage message2 = message.value();
		
		log.info("Value: {}", message.value());
		log.info("Content: {}", message2.getContent());
		log.info("DataTime: {}", message2.getDateTime());
		log.info("Headers: {}", message.headers());
		log.info("Partition: {}", message.partition());
		log.info("Topic: {}", message.topic());
		log.info("Timestamp: {}", message.timestamp());
	}
}
