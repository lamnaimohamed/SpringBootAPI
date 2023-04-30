package com.example.demo.Dao;

import com.example.demo.Model.Lot;
import com.example.demo.Model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepo extends JpaRepository<Niveau,Long> {
}
