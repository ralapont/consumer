package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.Direccion;
import com.example.demo.model.repository.ClienteRepository;
import com.example.productor.avro.ClienteAvro;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumerService {
	
	private final ClienteRepository clienteRepository;

	@KafkaListener(topics = "${app.config.topic-name}", groupId = "${app.config.grooup-id}")
	public void listen(ConsumerRecord<String, ClienteAvro> message) {
		
		log.info("offset: {}", message.offset());
		log.info("key: {}", message.key());
		
		ClienteAvro clienteAvro = message.value();
		
		log.info("Value: {}", message.value());
		log.info("Cliente nombre: {}", clienteAvro.getCliente().getNombre());
		log.info("Cliente apellido: {}", clienteAvro.getCliente().getApellido());
		log.info("Headers: {}", message.headers());
		log.info("Partition: {}", message.partition());
		log.info("Topic: {}", message.topic());
		log.info("Timestamp: {}", message.timestamp());
		
		Cliente clienteEntity = buildEntity(clienteAvro);
		clienteRepository.save(clienteEntity);
	}

	private Cliente buildEntity(ClienteAvro clienteAvro) {
		Direccion direccion = Direccion.builder()
				.nombre(clienteAvro.getCliente().getDireccion().getNombre().toString())
				.tipoVia(clienteAvro.getCliente().getDireccion().getTipoVia().toString())
				.numero(clienteAvro.getCliente().getDireccion().getNumero().toString())
				.piso(clienteAvro.getCliente().getDireccion().getPiso().toString())
				.codigoPostal(clienteAvro.getCliente().getDireccion().getCodigoPostal().toString())
				.poblacion(clienteAvro.getCliente().getDireccion().getPoblacion().toString())
				.provincia(clienteAvro.getCliente().getDireccion().getProvincia().toString())
				.build();
		
		return Cliente.builder()
				.nombre(clienteAvro.getCliente().getNombre().toString())
				.apellido(clienteAvro.getCliente().getApellido().toString())
				.nif(clienteAvro.getCliente().getNif().toString())
				.telefono(clienteAvro.getCliente().getTelefono().toString())
				.edad(clienteAvro.getCliente().getEdad())
				.nombre(clienteAvro.getCliente().getNombre().toString())
				.direccion(direccion)
				.build();
	}
}
