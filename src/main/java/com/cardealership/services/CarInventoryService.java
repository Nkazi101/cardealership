package com.cardealership.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealership.models.Car;
import com.cardealership.models.CarBid;
import com.cardealership.repositories.CarBidRepository;
import com.cardealership.repositories.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarInventoryService {

    @Autowired
  CarRepository carRepository;

  @Autowired
  CarBidRepository carBidRepository;

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public Car getCar(Long id){
        return carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Car Not Found"));
    }

    public List<Car>getAllCars(){
        return carRepository.findAll();
    }

    public List<Car>searchCars(String makeModel){
        return carRepository.findByMakeModelContaining(makeModel);
    }

    public Car updateCar(Long id,Car car){
        Car existingCar = getCar(id);
        existingCar.setManufacturerName(car.getManufacturerName());
        existingCar.setDateOfPurchase(car.getDateOfPurchase());
        existingCar.setMileage(car.getMileage());
        existingCar.setPrice(car.getPrice());
        existingCar.setMakeModel(car.getMakeModel());
        existingCar.setDescription(car.getDescription());
        existingCar.setPictureUrl(car.getPictureUrl());
        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public void sellCar(Long id){
        Car car = carRepository.findById(id).orElse(null);
        if (car != null){
            car.setSold(true);
            carRepository.save(car);
        }
    }

    // public List<Car> isBidable(){
    //     LocalDate cutoffDate = LocalDate.now().minusDays(120);
    //     return carRepository.findByPurchaseDateBefore(cutoffDate);

    // }

    public void placeBid(Car car, CarBid bid){
        car.setBidPrice(bid.getBidAmount());

        carBidRepository.save(bid);
        carRepository.save(car);

        
    }






    // public List<Car> getAvailableCars() {
    //     return carRepository.findBySoldFalse();
    // }


    
}
