package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    boolean check(User dataUser);
    void importToDb(List<MultipartFile> multipartfiles);
}
