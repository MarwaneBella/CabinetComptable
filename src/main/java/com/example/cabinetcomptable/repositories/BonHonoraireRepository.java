package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.BonHonoraire;
import com.example.cabinetcomptable.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BonHonoraireRepository extends JpaRepository<BonHonoraire, Long> {

    BonHonoraire findTopByOrderByIdBhDesc();

    @Query("select b from BonHonoraire b  where b.idBh =( select max(c.idBh) from BonHonoraire c where year(c.dateBh) = year(?1) ) ")
    BonHonoraire selectLastBonHonoraire(Date date);

    @Query(" select sum(b.montantPayer) from BonHonoraire b where year(b.dateBh) = year(?1) and b.valide = true ")
    Double selectSumOfRecettePerYear(Date date);

    @Query(" select sum(b.montantPayer) from BonHonoraire b where month(b.dateBh) = month(?1) and b.valide = true ")
    Double selectSumOfRecettePerMonth(Date date);

    @Query("select b from BonHonoraire b where b.client =?1 and b.status=false and b.valide =true  ORDER BY b.dateBh ASC ")
    List<BonHonoraire> selectListBonHonoraireByClient(Client client);

}
