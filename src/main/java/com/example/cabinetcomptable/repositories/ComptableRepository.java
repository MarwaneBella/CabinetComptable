package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Comptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptableRepository extends JpaRepository<Comptable,String> {

    Comptable findByUsernameAndPassword(String username, String password);
}
