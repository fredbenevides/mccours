package com.fredbenevides.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fredbenevides.cursomc.domain.Category;
import com.fredbenevides.cursomc.repositories.CategoryRepository;
import com.fredbenevides.cursomc.services.exceptions.DataIntegrityException;
import com.fredbenevides.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}

	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Category update(Category obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is impossible to delete a category which has products!");
		}
	}

	public List<Category> findAll() {
		return repo.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}