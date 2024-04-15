package edu.cibertec.PetShopProject.service;

import java.io.FileNotFoundException;
import java.util.List;
import edu.cibertec.PetShopProject.entity.Mascota;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;


public interface MascotaService {
	
	//metodos a utilizar
	public List<Mascota>listarMascota();
	//public List<Mascota>listarMascotaRazaObservacion(String raza, String observacion);
	public Mascota obtenerMascota(int id_mascota);
	public Mascota ingresarMascota(Mascota objMascota);
	public Mascota actualizarMascota(Mascota objMascota);
	public void eliminarMascota(Mascota objMascota);
	public JasperPrint exportReport()throws FileNotFoundException, JRException;
}
