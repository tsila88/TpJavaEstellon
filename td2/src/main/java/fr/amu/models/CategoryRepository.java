package fr.amu.models;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, String>{
	
}
