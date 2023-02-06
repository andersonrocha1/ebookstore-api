package com.andersondev.ebookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andersondev.ebookstore.domain.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
