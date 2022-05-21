package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonHonoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BonHonoraireRepository extends JpaRepository<BonHonoraire, Long> {

    BonHonoraire findTopByOrderByIdBhDesc();

    @Query(" select sum(b.montantPayer) from BonHonoraire b where year(b.dateBh) = year(?1) ")
    Double selectSumofRecettePerYear(Date date);
}
