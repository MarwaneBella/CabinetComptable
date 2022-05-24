package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBA;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface LignBARepository extends JpaRepository<LignBA,Long> {

    @Query(nativeQuery = true, value = "SELECT p.designation  FROM lign_ba l INNER JOIN bon_achat b USING(id_ba) INNER JOIN produit p  USING(reference) where b.valide = true GROUP BY l.reference ORDER BY SUM(quantite) desc LIMIT 5")
    List <String> selectDesignationTop5ByOrderByQuantitieOfLignBH();

    @Query(nativeQuery = true, value = "SELECT sum(l.quantite)  FROM lign_ba l INNER JOIN bon_achat b USING(id_ba) INNER JOIN produit p  USING(reference) where b.valide = true GROUP BY l.reference ORDER BY SUM(quantite) desc LIMIT 5")
    List <String> selectSumQuantiteTop5ByOrderByQuantitieOfLignBH();

}

