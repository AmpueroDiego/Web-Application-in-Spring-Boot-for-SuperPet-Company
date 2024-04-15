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

import edu.cibertec.PetShopProject.entity.Cliente;
import edu.cibertec.PetShopProject.service.ClienteService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class ClienteController {
	@Autowired
	private ClienteService servicioCliente;
	
	@GetMapping("lisCliente")
	public ModelAndView listarCliente() {
		ModelAndView mav = new ModelAndView("listadoClientes");
		mav.addObject("listaClientes",servicioCliente.listarClientes());
		return mav;
	}
	
	@GetMapping("frmCliente")
	public ModelAndView nuevoCliente() {
		ModelAndView mav = new ModelAndView("clienteForm");
		mav.addObject("cliente",new Cliente());
		return mav;
		
	}
	
	@PostMapping("frmCliente/ingresar")
	public String ingresarCliente(@ModelAttribute(name="cliente")Cliente objCliente) {
		servicioCliente.ingresarCliente(objCliente);
		return "redirect:/lisCliente";
	}
	
	@GetMapping("obtenerCliente")
	public ModelAndView obtenerCliente(@RequestParam(name="dni")String id) {
		ModelAndView mav = new ModelAndView("consultaCliente");
		mav.addObject("cliente",servicioCliente.obtenerCliente(id));
		return mav;
	}
	
	@PostMapping("frmCliente/actualizar")
	public String actualizarCliente(@ModelAttribute(name="cliente")Cliente objCliente) {
		Cliente tmpCliente = servicioCliente.obtenerCliente(objCliente.getDni());
		tmpCliente.setNombre(objCliente.getNombre());
		tmpCliente.setApellidos(objCliente.getApellidos());
		tmpCliente.setDireccion(objCliente.getDireccion());
		tmpCliente.setTelefono(objCliente.getTelefono());
		tmpCliente.setCorreo(objCliente.getCorreo());
		servicioCliente.actualizarCliente(tmpCliente);
		return "redirect:/lisCliente";
	}
	
	@GetMapping("eliminar")
	public ModelAndView eliminar(@RequestParam(name="dni")String dni) {
		ModelAndView mav = new ModelAndView("listadoClientes");
		Cliente objCliente= servicioCliente.obtenerCliente(dni);
		servicioCliente.eliminarCliente(objCliente);
		mav.addObject("listaClientes",servicioCliente.listarClientes());
		return mav;
	}
		
		@GetMapping("reportePDF/clientes")
		public void exportarPDFCliente(HttpServletResponse response) throws JRException, IOException{
			response.addHeader("Content-disposition", "inline; filename"+"cliente.pdf");
			response.setContentType("application/pdf");
			ServletOutputStream outputStream=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(servicioCliente.exportReportclientes(), outputStream);
			outputStream.flush();
			outputStream.close();
	}
}
