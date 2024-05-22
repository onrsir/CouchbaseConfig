package com.cb.Couchbase.controller;


import com.cb.Couchbase.model.Customer;
import com.cb.Couchbase.model.User;
import com.cb.Couchbase.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getCustomerById(@PathVariable Integer id){
        return customerRepo.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCustomerById(@PathVariable Integer id){
        customerRepo.deleteById(id);
        return ResponseEntity.ok("customer deleted successfully");
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return ResponseEntity.ok("customer updated successfully");
    }


    @GetMapping("search/byNameLike")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> searchCustomerByNameLike(@RequestParam String name){
        return customerRepo.findByNameLike(name);
    }

    @GetMapping("search/byName")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> searchCustomerByName(@RequestParam String name){
        return customerRepo.findByName(name);
    }


}
