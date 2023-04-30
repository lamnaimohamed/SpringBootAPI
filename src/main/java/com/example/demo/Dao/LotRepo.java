package com.example.demo.Dao;

import com.example.demo.Model.Lot;
import com.example.demo.Model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LotRepo extends JpaRepository<Lot,Long> {

}
