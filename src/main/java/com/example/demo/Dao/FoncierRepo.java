package com.example.demo.Dao;

import com.example.demo.Model.Foncier;
import com.example.demo.Model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoncierRepo extends JpaRepository<Foncier,Long> {
}
