package edu.cibertec.PetShopProject.service;

import java.util.List;
import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import edu.cibertec.PetShopProject.entity.Cliente;

public interface ClienteService {
	public List<Cliente> listarClientes();
	public Cliente obtenerCliente(String id);
	public Cliente ingresarCliente(Cliente cliente);
	public Cliente actualizarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);
	public JasperPrint exportReportclientes() throws FileNotFoundException,JRException;
}
