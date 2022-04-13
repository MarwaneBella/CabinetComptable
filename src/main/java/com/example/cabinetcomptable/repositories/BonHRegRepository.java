package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonHReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonHRegRepository extends JpaRepository<BonHReg,Long> {

}
