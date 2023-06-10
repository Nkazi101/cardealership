package com.cardealership.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardealership.models.Buyer;
import com.cardealership.models.Car;
import com.cardealership.models.CarBid;
import com.cardealership.repositories.BuyerRepository;
import com.cardealership.services.CarInventoryService;

@RestController
@RequestMapping("/cars")
public class CarInventoryController {

    @Autowired
    private CarInventoryService carInventoryService;

    @Autowired
    private BuyerRepository buyerRepository;


    // @PostMapping("/add")
    // public Car addCar(@RequestBody Car car){
    //     return carInventoryService.addCar(car);
    // }

    @RequestMapping(
    		value = "/add",
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		method = RequestMethod.POST
    )
   
    public ResponseEntity<Object> create(@RequestBody Car car) {

        try {
            Car savedCar = carInventoryService.addCar(car);
            return new ResponseEntity<Object>(savedCar, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



//     @GetMapping("/{id}")
//     public Car getCar(@PathVariable Long id){
//         return carInventoryService.getCar(id);
//     }
    
// }


@RequestMapping(
    value="/getCarbyID/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.GET
)
public ResponseEntity<Object> getCarbyID(@PathVariable Long id) {

    try {
        Car foundCar = carInventoryService.getCar(id);
        return new ResponseEntity<Object>(foundCar, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Error e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



@RequestMapping(
    value="/bid/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.POST

)
public ResponseEntity<Object> create(@PathVariable Long id, @RequestBody CarBid bid){

    try{
        Car car = carInventoryService.getCar(id);
        if (car != null && car.isBidable()){

            Long buyerId = bid.getBuyer().getId();

            Buyer buyer = buyerRepository.findById(buyerId).orElse(null);

            if (buyer !=null){
                bid.setBuyer(buyer);

                bid.setCar(car);

                carInventoryService.placeBid(car,bid);
            }
            
        }
        return new ResponseEntity<Object>(car, HttpStatus.OK);
    }
  
    catch(Exception e){
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }
    catch(Error e){
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
}