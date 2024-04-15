package edu.cibertec.PetShopProject.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.PetShopProject.entity.Horarios;
import edu.cibertec.PetShopProject.entity.Veterinario;
import edu.cibertec.PetShopProject.repository.HorariosRepository;
import edu.cibertec.PetShopProject.repository.VeterinarioRepository;
import edu.cibertec.PetShopProject.service.HorariosService;
import edu.cibertec.PetShopProject.service.VeterinarioService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class VeterinarioServiceImpl implements VeterinarioService,HorariosService {

	@Autowired
	private VeterinarioRepository repoVeterinario;
	@Autowired
	private HorariosRepository repoHorarios;
	@Override
	public List<Veterinario> listarVeterinario() {
		// TODO Auto-generated method stub
		return repoVeterinario.findAll();
	}

	@Override
	public Veterinario crearVeterinario(Veterinario objVeterinario) {
		// TODO Auto-generated method stub
		return repoVeterinario.save(objVeterinario);
	}

	@Override
	public List<Horarios> listarHorarios() {
		// TODO Auto-generated method stub
		return repoHorarios.findAll();
	}

	@Override
	public Veterinario buscarVeterinarioporId(int idveterinario) {
		// TODO Auto-generated method stub
		return repoVeterinario.findById(idveterinario).orElse(null);
	}

	@Override
	public List<Horarios> listarHorariosporVeterinario(Veterinario objVeterinario) {
		// TODO Auto-generated method stub
		return repoHorarios.findByVeterinario(objVeterinario);
	}

	@Override
	public Horarios ingresarHorario(Horarios horarios) {
		// TODO Auto-generated method stub
		return repoHorarios.save(horarios);
	}

	@Override
	public Horarios actualizarHorario(Horarios horarios) {
		// TODO Auto-generated method stub
		return repoHorarios.save(horarios);
	}

	@Override
	public Veterinario actualizarVeterinario(Veterinario objVeterinario) {
		// TODO Auto-generated method stub
		return repoVeterinario.save(objVeterinario);
	}

	@Override
	public void eliminarVeterinario(Veterinario objVeterinario) {
		// TODO Auto-generated method stub
		repoVeterinario.delete(objVeterinario);
	}

	@Override
	public void eliminarHorariosByVeterinario(Veterinario objVeterinario) {
		// TODO Auto-generated method stub
		 this.repoHorarios.findAllByVeterinario(objVeterinario)
         .forEach(horario -> this.repoHorarios.delete(horario));
	}

	@Override
	public JasperPrint exportReportvetarinario() throws FileNotFoundException, JRException {
		// TODO Auto-generated method stub
		List<Veterinario>listadoVet=repoVeterinario.findAll();
		File archivo=ResourceUtils.getFile("classpath:reporteveterinario.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds= new JRBeanCollectionDataSource(listadoVet);
		
		JasperPrint print=JasperFillManager.fillReport(report, null, ds);
		return print;
	}

	@Override
	public InputStream exportReportclientes() {
		// TODO Auto-generated method stub
		return null;
	}


}
