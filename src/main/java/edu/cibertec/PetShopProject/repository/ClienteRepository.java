package edu.cibertec.PetShopProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.PetShopProject.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
