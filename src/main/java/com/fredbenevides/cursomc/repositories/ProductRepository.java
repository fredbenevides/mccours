package com.fredbenevides.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}