package com.example.demo.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private String nombre;
	private String apellido;
	private String nif;
	private String telefono;
	private Long edad;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direcion_id", referencedColumnName = "id")
	private Direccion direccion;

}
