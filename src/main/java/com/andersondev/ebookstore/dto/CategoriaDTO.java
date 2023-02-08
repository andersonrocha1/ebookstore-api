package com.andersondev.ebookstore.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.andersondev.ebookstore.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Campo Nome, não pode ser vazio:")
	@Length(min = 5, max = 100, message = "Nome, precisa possuir entre 5 a 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo Descrição, não pode ser vazio:")
	@Length(min = 10, max = 100, message = "Descrição, precisa possuir entre 10 a 100 caracteres")
	private String descricao;
	
	
	public CategoriaDTO() {
		
	}


	public CategoriaDTO(Categoria obj) {
	
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
