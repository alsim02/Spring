package com.challenge.esercizio.controller;

import com.challenge.esercizio.model.Customer;
import com.challenge.esercizio.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CreateCustomer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){

        customer.setPsw(passwordEncoder.encode(customer.getPsw())); //cifratura della password in chiaro
        customerRepository.save(customer);
    }
}
