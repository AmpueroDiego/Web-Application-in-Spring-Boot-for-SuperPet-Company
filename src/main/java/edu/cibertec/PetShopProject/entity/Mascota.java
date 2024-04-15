package edu.cibertec.PetShopProject.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mascota;
	private String nombre;
	private String raza;
	private Date fecha_nacimiento;
	private String dni_cliente;
	private String observacion;
	
	
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Mascota(int id_mascota, String nombre, String raza, Date fecha_nacimiento, String dni_cliente,
			String observacion) {
		super();
		this.id_mascota = id_mascota;
		this.nombre = nombre;
		this.raza = raza;
		this.fecha_nacimiento = fecha_nacimiento;
		this.dni_cliente = dni_cliente;
		this.observacion = observacion;
	}


	public int getId_mascota() {
		return id_mascota;
	}


	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getDni_cliente() {
		return dni_cliente;
	}


	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
	
}

