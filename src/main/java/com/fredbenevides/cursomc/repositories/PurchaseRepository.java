package com.fredbenevides.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}