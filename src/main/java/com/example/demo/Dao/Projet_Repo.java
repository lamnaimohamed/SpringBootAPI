package com.example.demo.Dao;

import com.example.demo.Model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Projet_Repo extends JpaRepository<Projet,Long> {


    @Query(nativeQuery = true,
            value = "update section set geom = ST_GeomFromGeoJSON(:geom1) where id_section = :sec_id  ")
            void saveGeom(@Param("sec_id") Long sec_id,@Param("geom1") String geom1);

}
