package com.cardealership.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealership.models.CarBid;

@Repository
public interface CarBidRepository extends JpaRepository<CarBid,Long> {
    
}
