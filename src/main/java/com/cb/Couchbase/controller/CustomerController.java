package com.cb.Couchbase.controller;


import com.cb.Couchbase.model.Customer;
import com.cb.Couchbase.repo.CustomerRepo;
import com.couchbase.client.core.msg.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepo customerRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){

        customerRepo.save(customer);
        return ResponseEntity.ok("customer saved saccesfully!");

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }
}
