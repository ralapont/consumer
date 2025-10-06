package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String tipoVia;
	private String nombre;
	private String numero;
	private String piso;
	private String codigoPostal;
	private String poblacion;
	private String provincia;
	
    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;

}
