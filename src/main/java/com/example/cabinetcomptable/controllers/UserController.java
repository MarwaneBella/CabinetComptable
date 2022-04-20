package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> loginComptable(@RequestBody User user){

        if(userService.check(user)){
            return ResponseEntity.ok(user);

        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }





}
