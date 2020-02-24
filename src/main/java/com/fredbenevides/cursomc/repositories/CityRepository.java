package com.fredbenevides.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.City;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}