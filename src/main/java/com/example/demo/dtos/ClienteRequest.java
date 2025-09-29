package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteRequest {

	private String nombre;
	private String apellido;
	private String nif;
	private String telefono;
	private DireccionRequest direccion;
	private Integer edad;
}
