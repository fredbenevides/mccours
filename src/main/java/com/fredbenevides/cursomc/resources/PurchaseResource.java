package com.fredbenevides.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fredbenevides.cursomc.domain.Purchase;
import com.fredbenevides.cursomc.services.PurchaseService;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseResource {
	
	@Autowired
	private PurchaseService service;

	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Purchase> find(@PathVariable Integer id){
	
		Purchase obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}