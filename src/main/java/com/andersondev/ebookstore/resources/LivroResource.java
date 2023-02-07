package com.andersondev.ebookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andersondev.ebookstore.domain.Livro;
import com.andersondev.ebookstore.dto.CategoriaDTO;
import com.andersondev.ebookstore.dto.LivroDTO;
import com.andersondev.ebookstore.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long cat_id){
		//localhost:8080/livros?categoria=1
		
		List<Livro> list = service.findAll(cat_id);
		List<LivroDTO> listDTO = list.stream().map(x -> new LivroDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
				
	}
	
}
