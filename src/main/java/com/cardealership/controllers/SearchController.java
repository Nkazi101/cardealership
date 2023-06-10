package com.cardealership.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardealership.models.Car;
import com.cardealership.services.CarInventoryService;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private CarInventoryService carInventoryService;

    @RequestMapping(
        value="findByMakeModel/{makeModel}",
        produces=MediaType.APPLICATION_JSON_VALUE,
        method=RequestMethod.GET
    )

    public ResponseEntity<Object>findbyMakeModel(@PathVariable String makeModel){

        try{
            List<Car> foundCars = carInventoryService.searchCars(makeModel);
            return new ResponseEntity<Object>(foundCars, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

   
   
   
    // public List<Car> searchCars(@RequestParam String makeModel) {
    //     return carInventoryService.searchCars(makeModel);
    }
}
