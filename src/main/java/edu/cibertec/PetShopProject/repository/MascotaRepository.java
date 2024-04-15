package edu.cibertec.PetShopProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.cibertec.PetShopProject.entity.Mascota;


public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
	
	//metodos personalizados
	//public List<Mascota> findByRazaObservacion(String raza, String observacion);
	//problema con observacion
}
