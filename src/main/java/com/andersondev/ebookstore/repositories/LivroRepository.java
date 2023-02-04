package com.andersondev.ebookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersondev.ebookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
