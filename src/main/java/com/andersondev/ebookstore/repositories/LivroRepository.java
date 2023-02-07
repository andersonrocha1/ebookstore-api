package com.andersondev.ebookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andersondev.ebookstore.domain.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :cat_id ORDER BY titulo")
	List<Livro> findAllByCategory(@Param(value= "cat_id") Long cat_id);

}
