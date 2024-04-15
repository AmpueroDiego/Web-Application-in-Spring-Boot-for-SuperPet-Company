package edu.cibertec.PetShopProject.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.PetShopProject.entity.Cita;
import edu.cibertec.PetShopProject.repository.CitaRepository;
import edu.cibertec.PetShopProject.service.CitaService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CitaServiceImpl implements CitaService {
	@Autowired
	private CitaRepository repoCita;
	@Override
	public List<Cita> listarCitas() {
		// TODO Auto-generated method stub
		return repoCita.findAll();
	}

	@Override
	public Cita obtenerCita(Integer id) {
		// TODO Auto-generated method stub
		return repoCita.findById(id).orElse(null);
	}

	@Override
	public Cita ingresarCita(Cita cita) {
		// TODO Auto-generated method stub
		return repoCita.save(cita);
	}

	@Override
	public Cita actualizarCita(Cita cita) {
		// TODO Auto-generated method stub
		return repoCita.save(cita);
	}

	@Override
	public void eliminarCita(Cita cita) {
		// TODO Auto-generated method stub
		repoCita.delete(cita);
	}

	@Override
	public JasperPrint exportReportreservacitas() throws FileNotFoundException, JRException {
		// TODO Auto-generated method stub
		List<Cita>listadoCita=repoCita.findAll();
		File archivo=ResourceUtils.getFile("classpath:reportereservacitas.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds= new JRBeanCollectionDataSource(listadoCita);
		
		JasperPrint print=JasperFillManager.fillReport(report, null, ds);
		return print;
	}


	
}
