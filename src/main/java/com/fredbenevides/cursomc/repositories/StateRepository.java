package com.fredbenevides.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.State;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}