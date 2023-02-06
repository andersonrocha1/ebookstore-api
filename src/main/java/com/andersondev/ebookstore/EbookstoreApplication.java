package com.andersondev.ebookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andersondev.ebookstore.domain.Categoria;
import com.andersondev.ebookstore.domain.Livro;
import com.andersondev.ebookstore.repositories.CategoriaRepository;
import com.andersondev.ebookstore.repositories.LivroRepository;

@SpringBootApplication
public class EbookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EbookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros relacionados à tecnologia");
		
		Livro liv1 = new Livro(null, "Spring Boot", "Fernando Boaglio", "Acelere o desenvolvimento de microsserviços", "Spring Boot é uma maneira eficiente e eficaz de criar uma aplicação em Spring, de facilmente colocá-la no ar e que funciona sem depender de um servidor de aplicação. ", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(liv1));
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(liv1));
	}

}
