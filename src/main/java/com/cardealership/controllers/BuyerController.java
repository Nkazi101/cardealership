package com.cardealership.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cardealership.models.Buyer;
import com.cardealership.models.Transaction;
import com.cardealership.repositories.BuyerRepository;
import com.cardealership.services.BuyerService;
import com.cardealership.services.TransactionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    TransactionService transactionService;

//  @GetMapping("/")
// public String home(@ModelAttribute Buyer buyer, Model model) {


//     Buyer loginbuyer = buyerRepository.findById(buyer.getId()).orElse(null);
//     model.addAttribute("buyer", loginbuyer);
//     return "home";
// }
  

@GetMapping("/")
public String home(@ModelAttribute Buyer buyer, Model model){
    if (buyer != null && buyer.getId() != null) {
        Buyer loginbuyer = buyerRepository.findById(buyer.getId()).orElse(null);
        model.addAttribute("buyer", loginbuyer);
    }
    return "home";
}

 




//     @GetMapping("/")
// public String home(@ModelAttribute Buyer buyer, Model model) {

//     Buyer retrievedBuyer = buyerRepository.findById(buyer.getId()).orElse(null);
//     model.addAttribute("buyer", retrievedBuyer);
//     return "home";
// }

    @GetMapping("/sign-up")
    public String signUp(Model model){

        model.addAttribute("buyer", new Buyer());

        return "sign-up";

    }

    @PostMapping("/sign-up")
     public ModelAndView signUp(@ModelAttribute Buyer buyer, Model model){

        buyerService.save(buyer);

        return new ModelAndView("sign-in", "buyer", new Buyer());
     }
    
     @GetMapping("/sign-in")
     public String signIn(Model model){
 
         model.addAttribute("buyer", new Buyer());
 
         return "sign-in";
 
     }

    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute Buyer buyer, Model model, HttpSession session){
        
        Buyer loginBuyer = buyerService.signIn(buyer);

        if(loginBuyer == null){
            return "sign-up";
        }

        model.addAttribute("buyer", loginBuyer);
        session.setAttribute("buyer", loginBuyer);

        return "home";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable Long id , HttpSession session){

        Buyer loggedinBuyer = (Buyer) session.getAttribute("buyer");

        if(id == null && loggedinBuyer == null ){
            return "sign-in";
        }
        else if(id != null && loggedinBuyer == null){
            loggedinBuyer = buyerService.getBuyerById(id);
        }

        if(loggedinBuyer == null){
            return "sign-in";
        }

        model.addAttribute("buyer", loggedinBuyer);

        return "profile";

    }

      
    @GetMapping("/transactions")
    public String getAllTransactions(Model model){
        List<Transaction>transactions = transactionService.getAllTransactions();

        model.addAttribute("transactions", transactions);

        return "transactions";

    }
    
}
