package edu.cibertec.PetShopProject.service;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.PetShopProject.entity.Cita;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface CitaService {
	public List<Cita> listarCitas();
	public Cita obtenerCita(Integer id);
	public Cita ingresarCita(Cita cita);
	public Cita actualizarCita(Cita cita);
	public void eliminarCita(Cita cita);
	public JasperPrint exportReportreservacitas() throws FileNotFoundException,JRException;
}
