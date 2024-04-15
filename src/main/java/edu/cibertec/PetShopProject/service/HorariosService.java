package edu.cibertec.PetShopProject.service;

import java.util.List;
import edu.cibertec.PetShopProject.entity.Horarios;
import edu.cibertec.PetShopProject.entity.Veterinario;



public interface HorariosService {
	public List<Horarios> listarHorarios();
	public List<Horarios> listarHorariosporVeterinario(Veterinario objVeterinario);
	public Horarios ingresarHorario(Horarios horarios);
	public Horarios actualizarHorario(Horarios horarios);
	public void eliminarHorariosByVeterinario(Veterinario objVeterinario);
}
