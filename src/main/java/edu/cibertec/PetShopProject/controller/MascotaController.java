package edu.cibertec.PetShopProject.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.cibertec.PetShopProject.entity.Mascota;
import edu.cibertec.PetShopProject.service.MascotaService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;


//clase que recibe y manda las peticiones
//para que se pueda mapear desde la web
@Controller
@RequestMapping("/")
public class MascotaController {
	
	//invocamos al servicio
	@Autowired
	private MascotaService servicioMascota;
	
	@GetMapping("listMascota")
	public ModelAndView listarMacota() {
		ModelAndView mav=new ModelAndView("listadoMascota");
		mav.addObject("listadoMascota", servicioMascota.listarMascota());
		return mav;
	}
	
	@GetMapping("frmMascota")
	public ModelAndView nuevaMascota() {
		ModelAndView mav=new ModelAndView("mascotaForm");
		mav.addObject("mascota", new Mascota());
		return mav;
	}
	
	
	@PostMapping("frmMascota/ingresar")
	public String ingresarMascota(@ModelAttribute(name="mascota") Mascota objMascota) {
		servicioMascota.ingresarMascota(objMascota);
		return "redirect:/listMascota";
	}
	
	@GetMapping("obtener")
	public ModelAndView obtenerMascota(@RequestParam(name = "id_mascota")Integer id_mascota) {
		ModelAndView mav=new ModelAndView("mascotaactForm");
		mav.addObject("mascota",servicioMascota.obtenerMascota(id_mascota));
		return mav;
	}
	
	@PostMapping("frmMascota/actualizar")
	public String actualizarMascota(@ModelAttribute(name = "mascota")Mascota objMascota) {
		Mascota tmpMascota=servicioMascota.obtenerMascota(objMascota.getId_mascota());
		tmpMascota.setNombre(objMascota.getNombre());
		tmpMascota.setRaza(objMascota.getRaza());
		tmpMascota.setFecha_nacimiento(objMascota.getFecha_nacimiento());
		tmpMascota.setDni_cliente(objMascota.getDni_cliente());
		tmpMascota.setObservacion(objMascota.getObservacion());
		servicioMascota.actualizarMascota(tmpMascota);
		return "redirect:/listMascota";
	}
	
	@GetMapping("eliminarMascota")
	public ModelAndView eliminar(@RequestParam(name="id_mascota")Integer id_mascota) {
		ModelAndView mav=new ModelAndView("listadoMascota");
		Mascota objMascota=servicioMascota.obtenerMascota(id_mascota);
		servicioMascota.eliminarMascota(objMascota);
		mav.addObject("listadoMascota", servicioMascota.listarMascota());
		return mav;
	}
	
	@GetMapping("reportePDF/mascota")
	public void exportarPDFmascotas(HttpServletResponse response) throws JRException, IOException{
		response.addHeader("Content-disposition", "inline; filename"+"mascota.pdf");
		response.setContentType("application/pdf");
		ServletOutputStream outputStream=response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(servicioMascota.exportReport(), outputStream);
		outputStream.flush();
		outputStream.close();
	}

}
