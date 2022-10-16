package com.user.api.services;


import com.user.api.dtos.UserDto;
import com.user.api.dtos.UserLoginDto;
import com.user.api.entity.User;
import com.user.api.exceptions.ResourceNotFoundException;
import com.user.api.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllRegisteredUsers() {
    return userRepository.findAll();
  }

  public User addUser(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setMobileNo(userDto.getMobileNo());

    logger.info("user is inserted: ", user);
    return userRepository.save(user);
  }

  public ResponseEntity<User> getUserByUserName(final String userName) throws ResourceNotFoundException {

    User user = userRepository.findByEmail(userName);
    if (user == null) {
      logger.warn("user {} is not found", userName);
      throw new ResourceNotFoundException("user is not found with id =" + userName);
    }

    return new ResponseEntity<>(user, HttpStatus.OK);
  }


  public Boolean checkLogin(final UserLoginDto userLoginDto) throws ResourceNotFoundException {

    User user = userRepository.findByEmail(userLoginDto.getEmail());
    Boolean isValidUser = false;
    if (user != null) {
      if (user.getPassword().equals(userLoginDto.getPassword())) {
        isValidUser = true;
      }
    }

    return isValidUser;
  }

}
