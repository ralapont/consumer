package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.productor.avro.clienteAvro;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumerService {

	@KafkaListener(topics = "${app.config.topic-name}", groupId = "${app.config.grooup-id}")
	public void listen(ConsumerRecord<String, clienteAvro> message) {
		
		log.info("offset: {}", message.offset());
		log.info("key: {}", message.key());
		
		clienteAvro clienteAvro = message.value();
		
		log.info("Value: {}", message.value());
		log.info("Cliente nombre: {}", clienteAvro.getCliente().getNombre());
		log.info("Cliente apellido: {}", clienteAvro.getCliente().getApellido());
		log.info("Headers: {}", message.headers());
		log.info("Partition: {}", message.partition());
		log.info("Topic: {}", message.topic());
		log.info("Timestamp: {}", message.timestamp());
	}
}
