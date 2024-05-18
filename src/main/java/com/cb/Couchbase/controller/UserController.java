package com.cb.Couchbase.controller;


import com.cb.Couchbase.model.User;
import com.cb.Couchbase.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveUser(@RequestBody User user){
        userRepo.save(user);
        return ResponseEntity.ok("user saved succesfully");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllCustomers(){
        return userRepo.findAll();
    }
}
