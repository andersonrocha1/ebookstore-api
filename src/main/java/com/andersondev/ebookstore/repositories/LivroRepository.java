package com.andersondev.ebookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.ebookstore.domain.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long> {

}
