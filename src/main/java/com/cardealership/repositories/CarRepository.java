package com.cardealership.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cardealership.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c WHERE c.makeModel LIKE %:makeModel%")
    List<Car>findByMakeModelContaining(String makeModel);


    List<Car> findBySoldFalse();

    // List<Car>findByPurchaseDateBefore(LocalDate date);


}

