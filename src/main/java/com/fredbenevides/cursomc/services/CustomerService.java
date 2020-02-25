package com.fredbenevides.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredbenevides.cursomc.domain.Customer;
import com.fredbenevides.cursomc.repositories.CustomerRepository;
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
}