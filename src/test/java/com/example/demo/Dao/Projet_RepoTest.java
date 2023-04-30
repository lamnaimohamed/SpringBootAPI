package com.example.demo.Dao;

import com.example.demo.Dtos.ProjectDTO;
import com.example.demo.Model.*;
import com.example.demo.Service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class Projet_RepoTest {
@Autowired
    private Projet_Repo projetRepository;

    @Autowired
    private ProvinceRepo provinceRepo;

    @Autowired
    public Service service;



    @Test
    public void gg(){

    }
    @Test
public void get(){
    this.projetRepository.findAll().forEach(System.out::println);


        Set<Section> sections = new HashSet<>();
        sections.add(Section.builder().geom(" {\n" +
                "        \"coordinates\": [\n" +
                "          [\n" +
                "            -2.9453458312220846,\n" +
                "            35.16157814001487\n" +
                "          ],\n" +
                "          [\n" +
                "            -2.9288468765474818,\n" +
                "            35.14628983748524\n" +
                "          ],\n" +
                "          [\n" +
                "            -2.9981424861814787,\n" +
                "            35.114804876181736\n" +
                "          ],\n" +
                "          [\n" +
                "            -2.9321466674821863,\n" +
                "            35.078807160182606\n" +
                "          ],\n" +
                "          [\n" +
                "            -3.072937747375363,\n" +
                "            35.039191320227545\n" +
                "          ]\n" +
                "        ],\n" +
                "        \"type\": \"LineString\"\n" +
                "      }").province(provinceRepo.findAll().get(0)).build());

        Projet p = this.service.saveProjet(Projet.builder().objet("test1").sections(sections).build());
        for(Section s: p.getSections()){
            this.service.saveGeom(PersistgeomSections.builder().section(s.getId_section()).geometry(s.getGeom()).build());


        }

}

    @Test
    public void save1(){
        Set<Section> sections = new HashSet<>();
        sections.add(Section.builder().province(provinceRepo.findAll().get(0)).build());


       Projet projet =  this.projetRepository.findAll().get(0);
       projet.setSections(sections);

        projetRepository.save(projet);
    }




}











