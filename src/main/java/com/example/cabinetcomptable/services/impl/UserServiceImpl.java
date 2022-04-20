package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.User;
import com.example.cabinetcomptable.repositories.UserRepository;
import com.example.cabinetcomptable.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean check(User dataUser){
        User user = userRepository.findByUsernameAndPassword(dataUser.getUsername(), dataUser.getPassword());

        if(user != null){
            return true;
        }

        return false;
    }

}
