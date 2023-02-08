package com.andersondev.ebookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PutMapping(value = "/{id}") //Quando queira atualizar tudo
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro obj) {
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")// Quando queria atualizar apenas um atributo
	public ResponseEntity<Livro> updatePath(@PathVariable Long id, @RequestBody Livro obj) {
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> insert(@RequestParam(value = "categoria", defaultValue = "0") Long cat_id,
			@RequestBody Livro obj){
		
		Livro newObj = service.insert(cat_id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
