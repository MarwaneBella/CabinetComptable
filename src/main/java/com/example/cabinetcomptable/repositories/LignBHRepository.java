package com.example.cabinetcomptable.repositories;

import com.example.cabinetcomptable.entities.LignBH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignBHRepository extends JpaRepository<LignBH,Long> {
}
