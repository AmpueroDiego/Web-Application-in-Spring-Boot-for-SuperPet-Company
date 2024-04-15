package edu.cibertec.PetShopProject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.cibertec.PetShopProject.entity.Horarios;
import edu.cibertec.PetShopProject.entity.Veterinario;
import edu.cibertec.PetShopProject.service.HorariosService;
import edu.cibertec.PetShopProject.service.VeterinarioService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;


@Controller
@RequestMapping("/")
public class VeterinarioController {
	@Autowired
	private VeterinarioService servicioVeterinario;
	@Autowired
	private HorariosService servicioHorario;
	
	@GetMapping("listadoVeterinario")
	public ModelAndView listarVeterinario() {
		ModelAndView mv = new ModelAndView("listadoVeterinario");
		mv.addObject("listadoVeterinario",servicioVeterinario.listarVeterinario());
		return mv;
	}

	
	@GetMapping("frmVeterinario")
	public ModelAndView nuevoVeterinario() 
	{
		ModelAndView mv = new ModelAndView("veterinarioNForm");
		Veterinario objVeterinario = new Veterinario();
	    List<Horarios> horariosList = new ArrayList<>();
	    objVeterinario.setHorarios(horariosList);
	    
	    mv.addObject("veterinario", objVeterinario);
		return mv;
	}
	
	@PostMapping("veterinarioForm/ingresar")
	public String ingresarProducto(@ModelAttribute(name="veterinario") Veterinario objVeterinario)
	{
		List<Horarios> tempHorarios = objVeterinario.getHorarios(); 
		servicioVeterinario.crearVeterinario(objVeterinario);
		
			for(Horarios horario : tempHorarios ) {
			horario.setVeterinario(objVeterinario);
			servicioHorario.ingresarHorario(horario);
			}
		return "redirect:/listadoVeterinario";
	}
	
	@GetMapping("veterinarioForm/obtener")
	public ModelAndView verDetalle(@RequestParam(name="idveterinario")Integer idveterinario)
	{
		ModelAndView mv = new ModelAndView("veterinarioForm");
		Veterinario objVeterinario = servicioVeterinario.buscarVeterinarioporId(idveterinario);
		mv.addObject("veterinario",objVeterinario);
		mv.addObject("horarios",servicioHorario.listarHorariosporVeterinario(objVeterinario));
		 
		return mv;
	}
	
	
	@PostMapping("veterinarioForm/actualizar")
	  public String actualizarVeterinario(@ModelAttribute("veterinario")Veterinario objVeterinario) { 
		
		List<Horarios> tempHorarios = objVeterinario.getHorarios(); 
		objVeterinario.setHorarios(new ArrayList<>());
		servicioVeterinario.actualizarVeterinario(objVeterinario); 
		
		for(Horarios horario : tempHorarios ) {
			horario.setVeterinario(objVeterinario);
			servicioHorario.actualizarHorario(horario);
		}
		 
		 return "redirect:/listadoVeterinario";
	  }
	 
	
		@GetMapping("veterinarioForm/eliminar")
	  public ModelAndView eliminarProducto(@RequestParam(name="idveterinario")Integer idveterinario) 
	  {
			  ModelAndView mv = new ModelAndView("listadoVeterinario");  
			  Veterinario veterinario = servicioVeterinario.buscarVeterinarioporId(idveterinario);
			  servicioHorario. eliminarHorariosByVeterinario(veterinario);
			  servicioVeterinario.eliminarVeterinario(veterinario);
			  mv.addObject("listadoVeterinario",servicioVeterinario.listarVeterinario());
			  return mv;
	  }	  
				
				@GetMapping("reportePDF/veterinario")
				public void exportarPDFVeterinario(HttpServletResponse response) throws JRException, IOException{
					response.addHeader("Content-disposition", "inline; filename"+"veterinario.pdf");
					response.setContentType("application/pdf");
					ServletOutputStream outputStream=response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(servicioVeterinario.exportReportvetarinario(), outputStream);
					outputStream.flush();
					outputStream.close();
	  }
}
