package com.fredbenevides.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}