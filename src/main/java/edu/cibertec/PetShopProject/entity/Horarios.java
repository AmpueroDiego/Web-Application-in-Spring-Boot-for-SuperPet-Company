package edu.cibertec.PetShopProject.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Horarios")
public class Horarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhorario;
	@ManyToOne
	@JoinColumn(name="idveterinario")
	private Veterinario veterinario;
	private String dia;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime  horainicio;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime  horafin;
	
	public Horarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horarios(int idhorario, Veterinario veterinario, String dia, LocalTime horainicio, LocalTime horafin) {
		super();
		this.idhorario = idhorario;
		this.veterinario = veterinario;
		this.dia = dia;
		this.horainicio = horainicio;
		this.horafin = horafin;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}

	public LocalTime getHorafin() {
		return horafin;
	}

	public void setHorafin(LocalTime horafin) {
		this.horafin = horafin;
	}

	
}
