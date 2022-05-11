package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonAchatRepository extends JpaRepository<BonAchat,Long> {

    BonAchat findTopByOrderByIdBaDesc();
}
