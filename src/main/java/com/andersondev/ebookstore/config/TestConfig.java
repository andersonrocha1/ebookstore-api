package com.andersondev.ebookstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andersondev.ebookstore.domain.Categoria;
import com.andersondev.ebookstore.domain.Livro;
import com.andersondev.ebookstore.repositories.CategoriaRepository;
import com.andersondev.ebookstore.repositories.LivroRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Categoria cat1 = new Categoria(null, "Informática", "Livros relacionados à tecnologia");
		Categoria cat2 = new Categoria(null, "Fantasia", "Livros sobre lendas e fantasia");
		Categoria cat3 = new Categoria(null, "Ficçao Cientifica", "Livros sobre ficção");
		Categoria cat4 = new Categoria(null, "Cinema", "Livros ao mudno do cinema");

		Livro liv1 = new Livro(null, "Spring Boot", "Fernando Boaglio", "Acelere o desenvolvimento de microsserviços",
				"Spring Boot é uma maneira eficiente e eficaz de criar uma aplicação em Spring, de facilmente colocá-la no ar e que funciona sem depender de um servidor de aplicação. ",
				cat1);
		Livro liv2 = new Livro(null, "Alice no País das Maravilhas", "Lewis Carroll", "Alice talvez seja a obra mais interpretada por psicólogos", "sem dúvida é uma das que mais serviu de inspiração para tatuagens das gerações X, Y e Z", cat2);
		Livro liv3 = new Livro(null, "Duna", "Frank Herbert", "Duna é um romance de ficção científica", "Vencedor do prêmio Hugo de 1966, Duna é considerado o livro de ficção científica mais vendido de todos os tempos", cat3);
		Livro liv4 = new Livro(null, "CINEMA NEGRO BRASILEIRO", "Noel dos Santos", "Um livro sobre o cinema negro no Brasil", "Embora a mistura cultural do povo deste país tenha como influência poderosa a fonte afro-brasileira", cat4);
		
		

		cat1.getLivros().addAll(Arrays.asList(liv1));
		cat2.getLivros().addAll(Arrays.asList(liv2));
		cat3.getLivros().addAll(Arrays.asList(liv3));
		cat4.getLivros().addAll(Arrays.asList(liv4));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4));
*/
	}

}
