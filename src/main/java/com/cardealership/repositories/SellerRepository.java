package com.cardealership.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealership.models.Buyer;

@Repository
public interface SellerRepository extends JpaRepository<Buyer,Long> {
    
    
}

