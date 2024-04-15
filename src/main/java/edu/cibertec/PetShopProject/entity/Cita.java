package edu.cibertec.PetShopProject.entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reserva_citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cita;
	private String dni_cliente;
	private int id_mascota;
	private Date fecha_cita;
	private String motivo;
	
	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cita(int id_cita, String dni_cliente, int id_mascota, Date fecha_cita, String motivo) {
		super();
		this.id_cita = id_cita;
		this.dni_cliente = dni_cliente;
		this.id_mascota = id_mascota;
		this.fecha_cita = fecha_cita;
		this.motivo = motivo;
	}

	public int getId_cita() {
		return id_cita;
	}

	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}

	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public Date getFecha_cita() {
		return fecha_cita;
	}

	public void setFecha_cita(Date fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
