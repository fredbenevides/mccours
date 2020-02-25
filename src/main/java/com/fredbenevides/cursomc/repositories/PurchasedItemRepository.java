package com.fredbenevides.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fredbenevides.cursomc.domain.PurchasedItem;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItem, Integer>{

}