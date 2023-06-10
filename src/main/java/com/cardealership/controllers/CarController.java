package com.cardealership.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cardealership.models.Car;
import com.cardealership.services.CarInventoryService;


@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarInventoryService carInventoryService;

    @GetMapping("/available")
    public String getAvailableCars(Model model){
        List<Car> cars = carInventoryService.getAllCars();
        model.addAttribute("cars", cars);
        return "availablecars";
    }

    @GetMapping("/{id}")
    public String getCarDetails(@PathVariable Long id, Model model) {
        Car car = carInventoryService.getCar(id);
        model.addAttribute("car", car);
       
        return "cardetails"; 
    }


}
