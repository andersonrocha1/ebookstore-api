package com.andersondev.ebookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andersondev.ebookstore.domain.Categoria;
import com.andersondev.ebookstore.dto.CategoriaDTO;
import com.andersondev.ebookstore.repositories.CategoriaRepository;
import com.andersondev.ebookstore.services.exceptions.DatabaseException;
import com.andersondev.ebookstore.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {

		return repository.findAll();
	}

	public Categoria findById(Long id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);

	}

	public Categoria update(Categoria obj) {
		Categoria newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Categoria newObj, Categoria obj) {

		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
			} catch(EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			}catch(DataIntegrityViolationException e) {
				throw new DatabaseException("Categoria não pôde ser excluida, ela possui livros associados");
			}

	}

	public Categoria fromDTO(CategoriaDTO objDTO) {

		return new Categoria(objDTO.getId(), objDTO.getNome(), objDTO.getDescricao());

	}

}
