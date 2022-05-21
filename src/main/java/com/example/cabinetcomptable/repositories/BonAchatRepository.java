package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BonAchatRepository extends JpaRepository<BonAchat,Long> {
    //where year(b.dateBa) = year(?1)
    @Query("select b from BonAchat b  where b.idBa =( select max(c.idBa) from BonAchat c where year(c.dateBa) = year(?1) ) ")
    BonAchat selectLastBonAchat(Date date);
}
