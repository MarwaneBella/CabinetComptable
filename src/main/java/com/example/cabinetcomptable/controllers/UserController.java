package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        if(userService.check(user)){
            return ResponseEntity.ok(user);

        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @PostMapping(path = "/import-to-db")
    public void importUsersFromExcelToDb(@RequestPart(required = true) List<MultipartFile> files) {
        userService.importToDb(files);
    }





}
