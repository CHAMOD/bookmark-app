package com.user.api.controllers;

import com.user.api.dtos.UserDto;
import com.user.api.dtos.UserLoginDto;
import com.user.api.entity.User;
import com.user.api.exceptions.ResourceNotFoundException;
import com.user.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

  @Autowired
  UserService userService;


  @PostMapping("/register")
  public User createUser(@RequestBody @Valid UserDto user) {
    return userService.addUser(user);
  }

  @GetMapping(value = "/userProfile/{userName}")
  public ResponseEntity<User> getUserByUserName(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException {

    return userService.getUserByUserName(userName);

  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody UserLoginDto user) throws ResourceNotFoundException {
    Boolean isValidUser = userService.checkLogin(user);
    if (isValidUser) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
