package com.example.demo.Dao;

import com.example.demo.Model.Lot;
import com.example.demo.Model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepo extends JpaRepository<Province,Long> {
}
