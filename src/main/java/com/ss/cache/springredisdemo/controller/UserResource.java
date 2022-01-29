package com.ss.cache.springredisdemo.controller;

import com.ss.cache.springredisdemo.model.User;
import com.ss.cache.springredisdemo.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Map<String,User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") final String id){
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }


    @PostMapping("/update")
    public User updateUser(@RequestBody final User user){
        userRepository.update(user);
        return userRepository.findById(user.getId());
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") final String user){
        userRepository.delete(user);
    }
}
