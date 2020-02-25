package com.fredbenevides.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredbenevides.cursomc.domain.Purchase;
import com.fredbenevides.cursomc.repositories.PurchaseRepository;
import com.fredbenevides.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepository repo;
	
	public Purchase find(Integer id) {
		Optional<Purchase> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Purchase.class.getName()));
	}
}