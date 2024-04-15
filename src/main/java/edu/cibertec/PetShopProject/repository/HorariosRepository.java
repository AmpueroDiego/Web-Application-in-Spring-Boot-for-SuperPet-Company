package edu.cibertec.PetShopProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.PetShopProject.entity.Horarios;
import edu.cibertec.PetShopProject.entity.Veterinario;


public interface HorariosRepository extends JpaRepository<Horarios, Integer> {
	public List<Horarios> findByVeterinario (Veterinario objVeterinario);
	public List<Horarios> findAllByVeterinario(Veterinario objVeterinario);
}
