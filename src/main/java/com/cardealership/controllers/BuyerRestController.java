// package com.cardealership.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;

// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import com.cardealership.models.Buyer;
// import com.cardealership.services.BuyerService;


// @RestController
// @RequestMapping(value="/buyer")
// // @CrossOrigin("*")
// public class BuyerRestController {

//     @Autowired
//     BuyerService buyerService;   

//     @RequestMapping(
//         value = "/signUp",
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.POST
//     )
//     public ResponseEntity<Object> signUp(@RequestBody Buyer buyer) {

//         try {
           
    
//             Buyer savedBuyer = buyerService.save(buyer);
    
    
//             return new ResponseEntity<Object>(savedBuyer, HttpStatus.CREATED);
//         } catch(DataIntegrityViolationException e) {
//             System.out.println("Dupe email");
//             return new ResponseEntity<Object>("Dupe Email", HttpStatus.BAD_REQUEST);
//         } catch (Exception e) {
//             System.out.println(e);
//             return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
//         } catch (Error e) {
//             System.out.println(e);
//             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
    
//     }

//     @RequestMapping(
//         value = "/signIn",
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.POST
//     )
//     public ResponseEntity<Object> signIn(@RequestBody Buyer buyer) {

//         try {
           
    
//             Buyer loginBuyer = buyerService.signIn(buyer);
    
    
//             return new ResponseEntity<Object>(loginBuyer, HttpStatus.CREATED);
//         } catch(DataIntegrityViolationException e) {
//             System.out.println("Dupe email");
//             return new ResponseEntity<Object>("Dupe Email", HttpStatus.BAD_REQUEST);
//         } catch (Exception e) {
//             System.out.println(e);
//             return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
//         } catch (Error e) {
//             System.out.println(e);
//             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
    
//     }

// }
