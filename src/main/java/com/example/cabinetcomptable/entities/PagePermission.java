package com.example.cabinetcomptable.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PagePermission {

    @Id
    private String NamePermission;



    public String getNamePermission() {
        return NamePermission;
    }

    public void setNamePermission(String namePermission) {
        NamePermission = namePermission;
    }
}
