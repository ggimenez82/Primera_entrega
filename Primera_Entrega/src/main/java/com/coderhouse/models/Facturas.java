package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Facturas")
public class Facturas {
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
	private Long id;

	@Column(nullable = false)
	private String descripcion;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "persona_id")
	 private Personas persona;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL)
	 private List<Productos> lista_productos;

	

}
