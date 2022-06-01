package com.example.cabinetcomptable.services;

import com.example.cabinetcomptable.entities.PagePermission;
import com.example.cabinetcomptable.repositories.PagePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagePermissionService {
    @Autowired
    private PagePermissionRepository pagePermissionRepository;

    public PagePermission createNewPagePermission(PagePermission pagePermission) {
        return pagePermissionRepository.save(pagePermission);
    }
}
