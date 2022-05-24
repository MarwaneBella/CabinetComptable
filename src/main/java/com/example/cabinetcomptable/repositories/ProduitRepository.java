package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBH;
import com.example.cabinetcomptable.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,String> {

    List<Produit> findTop5ByOrderByQuantitieDisponibleDesc();


}
