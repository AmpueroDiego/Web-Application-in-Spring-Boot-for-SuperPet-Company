package edu.cibertec.PetShopProject.service;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.InputStream;

import edu.cibertec.PetShopProject.entity.Veterinario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface VeterinarioService {
	public List<Veterinario> listarVeterinario();
	public Veterinario buscarVeterinarioporId(int idveterinario);
	public Veterinario crearVeterinario(Veterinario objVeterinario);
	public Veterinario actualizarVeterinario(Veterinario objVeterinario);
	public void eliminarVeterinario(Veterinario objVeterinario);
	public InputStream exportReportclientes();
	public JasperPrint exportReportvetarinario() throws FileNotFoundException,JRException;
}
