package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,String> {
}
