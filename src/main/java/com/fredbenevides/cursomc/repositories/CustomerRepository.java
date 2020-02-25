package com.fredbenevides.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}