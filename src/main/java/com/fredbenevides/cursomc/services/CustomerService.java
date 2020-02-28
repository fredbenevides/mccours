package com.fredbenevides.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fredbenevides.cursomc.domain.Customer;
import com.fredbenevides.cursomc.dto.CustomerDTO;
import com.fredbenevides.cursomc.repositories.CustomerRepository;
import com.fredbenevides.cursomc.services.exceptions.DataIntegrityException;
import com.fredbenevides.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public Customer find(Integer id) {
		Optional<Customer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Customer.class.getName()));
	}

	public Customer update(Customer obj) {
		Customer newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It is impossible to delete a customer who has purchases");
		}
	}

	public List<Customer> findAll() {
		return repo.findAll();
	}
	
	public Page<Customer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Customer fromDTO(CustomerDTO objDTO) {
		return new Customer(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null);
	}
	
	private void updateData(Customer newObj, Customer obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}