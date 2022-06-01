package com.example.cabinetcomptable.controllers;


import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@PreAuthorize("hasRole('Admin')")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/add"})
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/getAll")
    public ResponseEntity< List<User> > getAllUsers(){
        return ResponseEntity.ok( userService.getAllUsers() );
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<User> getAllUsers(@PathVariable String id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        return  ResponseEntity.ok(userService.updateUser(id,user));
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable String id){
       userService.deleteUser(id);
    }

}
