package edu.cibertec.PetShopProject.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Veterinario")
public class Veterinario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idveterinario;
	private String nombresveterinario;
	private String apellidosveterinario;
	private int aniosexperiencia;
	private String telefono;
	private String correo;
	private int nrocolegiatura;
	private String puesto;
	@OneToMany(mappedBy = "veterinario")
	private List<Horarios> horarios;
	
	public Veterinario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veterinario(int idveterinario, String nombresveterinario, String apellidosveterinario, int aniosexperiencia,
			String telefono, String correo, int nrocolegiatura, String puesto, List<Horarios> horarios) {
		super();
		this.idveterinario = idveterinario;
		this.nombresveterinario = nombresveterinario;
		this.apellidosveterinario = apellidosveterinario;
		this.aniosexperiencia = aniosexperiencia;
		this.telefono = telefono;
		this.correo = correo;
		this.nrocolegiatura = nrocolegiatura;
		this.puesto = puesto;
		this.horarios = horarios;
	}

	public int getIdveterinario() {
		return idveterinario;
	}

	public void setIdveterinario(int idveterinario) {
		this.idveterinario = idveterinario;
	}

	public String getNombresveterinario() {
		return nombresveterinario;
	}

	public void setNombresveterinario(String nombresveterinario) {
		this.nombresveterinario = nombresveterinario;
	}

	public String getApellidosveterinario() {
		return apellidosveterinario;
	}

	public void setApellidosveterinario(String apellidosveterinario) {
		this.apellidosveterinario = apellidosveterinario;
	}

	public int getAniosexperiencia() {
		return aniosexperiencia;
	}

	public void setAniosexperiencia(int aniosexperiencia) {
		this.aniosexperiencia = aniosexperiencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getNrocolegiatura() {
		return nrocolegiatura;
	}

	public void setNrocolegiatura(int nrocolegiatura) {
		this.nrocolegiatura = nrocolegiatura;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<Horarios> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horarios> horarios) {
		this.horarios = horarios;
	}

	
}
