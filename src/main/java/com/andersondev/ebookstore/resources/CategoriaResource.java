package com.andersondev.ebookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andersondev.ebookstore.domain.Categoria;
import com.andersondev.ebookstore.dto.CategoriaDTO;
import com.andersondev.ebookstore.services.CategoriaService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping	
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@Valid @RequestBody Categoria obj){
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Long id) {
		
		Categoria obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
