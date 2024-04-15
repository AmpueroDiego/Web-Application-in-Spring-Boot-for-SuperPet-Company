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

import edu.cibertec.PetShopProject.entity.Cita;
import edu.cibertec.PetShopProject.service.CitaService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class CitaController {
	@Autowired
	private CitaService servicioCita;
	
	@GetMapping("lisCita")
	public ModelAndView listarCita() {
		ModelAndView mav = new ModelAndView("listadoCita");
		mav.addObject("listaCita",servicioCita.listarCitas());
		return mav;
	}
	
	@GetMapping("frmCita")
	public ModelAndView nuevoVehiculo() {
		ModelAndView mav = new ModelAndView("citaForm");
		mav.addObject("cita",new Cita());
		return mav;
	}
	
	@PostMapping("frmCita/ingresar")
	public String ingresarCita(@ModelAttribute(name="cita")Cita objCita) {
		servicioCita.ingresarCita(objCita);
		return "redirect:/lisCita";
	}
	
	@GetMapping("obtenerCita")
	public ModelAndView obtenerCita(@RequestParam(name="id")Integer id) {
		ModelAndView mav = new ModelAndView("consultaCita");
		mav.addObject("cita",servicioCita.obtenerCita(id));
		return mav;
	}
	
	@PostMapping("frmCita/actualizar")
	public String actualizarCita(@ModelAttribute(name="cita")Cita objCita) {
		Cita tmpCita = servicioCita.obtenerCita(objCita.getId_cita());
		tmpCita.setDni_cliente(objCita.getDni_cliente());
		tmpCita.setFecha_cita(objCita.getFecha_cita());
		tmpCita.setId_mascota(objCita.getId_mascota());
		tmpCita.setMotivo(objCita.getMotivo());
		servicioCita.actualizarCita(tmpCita);
		return "redirect:/lisCita";
	}
	
	@GetMapping("eliminarCita")
	public ModelAndView eliminar(@RequestParam(name="id")Integer id) {
		ModelAndView mav = new ModelAndView("listadoCita");
		Cita objCita= servicioCita.obtenerCita(id);
		servicioCita.eliminarCita(objCita);
		mav.addObject("listaCita",servicioCita.listarCitas());
		return mav;
	}	
		@GetMapping("reportePDF/Citas")
		public void exportarPDF(HttpServletResponse response) throws JRException, IOException{
			response.addHeader("Content-disposition", "inline; filename"+"cita.pdf");
			response.setContentType("application/pdf");
			ServletOutputStream outputStream=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(servicioCita.exportReportreservacitas(), outputStream);
			outputStream.flush();
			outputStream.close();
	}
}
