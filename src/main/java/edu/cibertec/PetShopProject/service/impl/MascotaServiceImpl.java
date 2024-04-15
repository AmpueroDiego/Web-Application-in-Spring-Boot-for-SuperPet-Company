package edu.cibertec.PetShopProject.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import edu.cibertec.PetShopProject.entity.Mascota;
import edu.cibertec.PetShopProject.repository.MascotaRepository;
import edu.cibertec.PetShopProject.service.MascotaService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


//clase estereotipo tipo service
@Service
public class MascotaServiceImpl implements MascotaService {
	
	//inyeccion de dependencias para que se instancie en tiempo de ejecucion
	@Autowired
	private MascotaRepository repoMascota;
	
	@Override
	public List<Mascota> listarMascota() {
		// TODO Auto-generated method stub
		return repoMascota.findAll();
		//metodo ya implementado por Spring
	}

//	@Override
//	public List<Mascota> listarMascotaRazaObservacion(String raza, String observacion) {
//		// TODO Auto-generated method stub
//		return repoMascota.findByRazaObservacion(raza, observacion);
//	}

	@Override
	public Mascota obtenerMascota(int id_mascota) {
		// TODO Auto-generated method stub
		return repoMascota.findById(id_mascota).orElse(null);
		//sino encuntra en id manda un nulo (tipo opcional)
	}

	@Override
	public Mascota ingresarMascota(Mascota objMascota) {
		// TODO Auto-generated method stub
		return repoMascota.save(objMascota);
	}

	@Override
	public Mascota actualizarMascota(Mascota objMascota) {
		// TODO Auto-generated method stub
		return repoMascota.save(objMascota);
	}

	@Override
	public void eliminarMascota(Mascota objMascota) {
		// TODO Auto-generated method stub
		repoMascota.delete(objMascota);
	}

	@Override
	public JasperPrint exportReport() throws FileNotFoundException, JRException {
		// TODO Auto-generated method stub
		List<Mascota>listarMascota=repoMascota.findAll();
		File archivo=ResourceUtils.getFile("classpath:reportemascotas.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds= new JRBeanCollectionDataSource(listarMascota);
		
		JasperPrint print=JasperFillManager.fillReport(report, null, ds);
		return print;
	}

}
