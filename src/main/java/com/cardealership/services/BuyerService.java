package com.cardealership.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealership.models.Buyer;
import com.cardealership.repositories.BuyerRepository;

@Service
public class BuyerService {
    
    @Autowired
    BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }
    
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer findByEmail(String email){
        return buyerRepository.findbyEmail(email);
    }

    public Buyer signIn(Buyer buyer) {

        return buyerRepository.signIn(buyer.getEmail(), buyer.getPassword());
       
    }

    public Buyer getBuyerById(Long buyerid){
        if (buyerRepository.findById(buyerid).isPresent()){
            return buyerRepository.findById(buyerid).get();
        }

        throw new Error("Buyer not found");
    }
}

