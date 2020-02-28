package com.fredbenevides.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fredbenevides.cursomc.domain.Customer;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Customer name cannot be empty")
	@Length(min = 5, max = 80, message = "Customer name must have at least 5 and at most 80")
	private String name;
	
	@NotEmpty(message = "Customer email cannot be empty")
	@Email(message = "Invalid email address")
	private String email;
	
	public CustomerDTO() {
		
	}
	
	public CustomerDTO(Customer obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
