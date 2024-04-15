package edu.cibertec.PetShopProject.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import edu.cibertec.PetShopProject.entity.Cliente;
import edu.cibertec.PetShopProject.repository.ClienteRepository;
import edu.cibertec.PetShopProject.service.ClienteService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository reporCliente;
	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return reporCliente.findAll();
	}

	@Override
	public Cliente obtenerCliente(String id) {
		// TODO Auto-generated method stub
		return reporCliente.findById(id).orElse(null);
	}

	@Override
	public Cliente ingresarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return reporCliente.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return reporCliente.save(cliente);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		reporCliente.delete(cliente);
	}

	@Override
	public JasperPrint exportReportclientes() throws FileNotFoundException, JRException {
		// TODO Auto-generated method stub
		List<Cliente>listadoCliente=reporCliente.findAll();
		File archivo=ResourceUtils.getFile("classpath:reporteclientes.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds= new JRBeanCollectionDataSource(listadoCliente);
		
		JasperPrint print=JasperFillManager.fillReport(report, null, ds);
		return print;
	}

}
