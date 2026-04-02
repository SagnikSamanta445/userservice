package com.sagnik445.userservice.controller;

import com.sagnik445.userservice.entities.UserInfoDto;
import com.sagnik445.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDto> getUser(@RequestParam String userId){
        try{
            UserInfoDto user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/v1/createUpdate")
    public ResponseEntity<UserInfoDto> createUpdateUser(@RequestBody UserInfoDto userInfoDto){
        try{
            UserInfoDto user = userService.createOrUpdateUser(userInfoDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}