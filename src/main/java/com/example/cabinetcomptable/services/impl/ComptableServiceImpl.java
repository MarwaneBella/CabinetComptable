package com.example.cabinetcomptable.services.impl;

import com.example.cabinetcomptable.entities.Comptable;
import com.example.cabinetcomptable.repositories.ComptableRepository;
import com.example.cabinetcomptable.services.ComptableService;
import org.springframework.stereotype.Service;

@Service
public class ComptableServiceImpl implements ComptableService {

    private ComptableRepository  comptableRepository;

    public ComptableServiceImpl(ComptableRepository comptableRepository) {
        this.comptableRepository = comptableRepository;
    }

    @Override
    public boolean check(Comptable dataComptable){
        Comptable comptable = comptableRepository.findByUsernameAndPassword(dataComptable.getUsername(),dataComptable.getPassword());

        if(comptable != null){
            return true;
        }

        return false;
    }

}
