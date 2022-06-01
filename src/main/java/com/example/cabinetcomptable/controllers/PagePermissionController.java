package com.example.cabinetcomptable.controllers;

import com.example.cabinetcomptable.entities.PagePermission;

import com.example.cabinetcomptable.services.PagePermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagePermissionController {

    @Autowired
    private PagePermissionService pagePermissionService;

    @PostMapping({"/createNewPagePermission"})
    public PagePermission createNewPagePermission(@RequestBody PagePermission pagePermission) {
        return pagePermissionService.createNewPagePermission(pagePermission);
    }

}
