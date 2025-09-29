package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DireccionRequest {
	
	private String tipoVia;
	private String nombre;
	private String numero;
	private String piso;
	private String codigoPostal;
	private String poblacion;
	private String provincia;

}
