package com.fredbenevides.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fredbenevides.cursomc.domain.Customer;
import com.fredbenevides.cursomc.dto.CustomerDTO;
import com.fredbenevides.cursomc.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Customer> find(@PathVariable Integer id){
	
		Customer obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CustomerDTO objDTO, @PathVariable Integer id){
		Customer obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
	
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> findAll(){
	
		List<Customer> list = service.findAll();
		List<CustomerDTO> listDTO = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value ="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CustomerDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linePerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name")String direction,
			@RequestParam(value = "direction", defaultValue = "ASC")String orderBy){
	
		Page<Customer> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<CustomerDTO> listDTO = list.map(obj -> new CustomerDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}