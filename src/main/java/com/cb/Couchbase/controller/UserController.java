package com.cb.Couchbase.controller;


import com.cb.Couchbase.model.User;
import com.cb.Couchbase.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id){
        return userRepo.findById(UUID.fromString(id)).get();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        userRepo.deleteById(UUID.fromString(id));
        return ResponseEntity.ok("user deleted successfully");
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userRepo.save(user);
        return ResponseEntity.ok("user updated successfully");
    }

    @GetMapping("search")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUser(@RequestParam String name){
        return userRepo.findByName(name);
    }

    @GetMapping("search/email")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUserByEmail(@RequestParam String email){
        return userRepo.findByEmail(email);
    }

    @GetMapping("search/nameAndEmail")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUserByNameAndEmail(@RequestParam String name, @RequestParam String email){
        return userRepo.findByNameAndEmail(name, email);
    }

    @GetMapping("search/nameOrEmail")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUserByNameOrEmail(@RequestParam String name, @RequestParam String email){
        return userRepo.findByNameOrEmail(name, email);
    }

    @GetMapping("search/like")
    @ResponseStatus(HttpStatus.OK)
    public List<User> searchUserLike(@RequestParam String name){
        return userRepo.findByNameLike(name);
    }


    @GetMapping("search/likeOrOrderByAscDesc")
    @ResponseStatus(HttpStatus.OK)
    public List<User> searchUserLikeOrOrderByAscDesc(@RequestParam String name, @RequestParam String email){
        return userRepo.findByNameLikeOrEmailLikeOrderByEmailAscEmailDesc(name, email);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllCustomers(){
        return userRepo.findAll();
    }
    @GetMapping("search/byNameLike")
    @ResponseStatus(HttpStatus.OK)
    public List<User> searchUserByNameLike(@RequestParam String name){
        return userRepo.findByNameLike(name);
    }


    @GetMapping("search/byEmailAndName")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUserByEmailAndName(@RequestParam String email, @RequestParam String name){
        return userRepo.findByEmailAndName(email, name);
    }

    @GetMapping("search/byEmailOrName")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> searchUserByEmailOrName(@RequestParam String email, @RequestParam String name){
        return userRepo.findByEmailOrName(email, name);
    }

    @GetMapping("search/byEmailLike")
    @ResponseStatus(HttpStatus.OK)
    public List<User> searchUserByEmailLike(@RequestParam String email){
        return userRepo.findByEmailLike(email);
    }
}
