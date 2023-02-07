package com.andersondev.ebookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersondev.ebookstore.domain.Livro;
import com.andersondev.ebookstore.repositories.LivroRepository;
import com.andersondev.ebookstore.services.exceptions.ResourceNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Long id) {
		
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Este ID = " + id +  " não pertence a nenhum Livro."));
				
	}

	public List<Livro> findAll(Long cat_id) {
		categoriaService.findById(cat_id);
		
		return repository.findAllByCategory(cat_id);
	}

}
