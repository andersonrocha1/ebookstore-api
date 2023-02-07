package com.andersondev.ebookstore.dto;

import java.io.Serializable;

import com.andersondev.ebookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String nome_autor;


	public LivroDTO() {
		
	}


	public LivroDTO(Livro obj) {
	
		id = obj.getId();
		titulo = obj.getTitulo();
		nome_autor = obj.getNome_autor();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getNome_autor() {
		return nome_autor;
	}


	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}


}
