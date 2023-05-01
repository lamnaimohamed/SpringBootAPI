package com.example.demo;

import com.example.demo.Model.PersistgeomSections;
import com.example.demo.Model.Personnel;
import com.example.demo.Model.Projet;
import com.example.demo.Model.Section;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("rest")
public class Controller {

    @Autowired
    public Service service;

    //endpoint get
    @GetMapping(value = "/")
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> index2(@RequestBody String test){
        return new ResponseEntity<>(test, HttpStatus.OK);
    }


    @PostMapping(value = "/saveProject")
    public ResponseEntity<?> saveProject(@RequestBody Projet projet){
        Projet p = this.service.saveProjet(projet);
        for(Section s: p.getSections()){
            this.service.saveGeom(PersistgeomSections.builder().section(s.getId_section()).geometry(s.getGeom()).build());


        }
        return new ResponseEntity<>(projet,HttpStatus.OK);
    }


    @GetMapping(value = "/addPersonnel")
    public ResponseEntity<?> addPersonnel(){
        return new ResponseEntity<>(this.service.ajoutPer(), HttpStatus.OK);
    }



    @GetMapping(value = "/getProvinecs")
    public ResponseEntity<?> getProvinecs(){
        return new ResponseEntity<>(this.service.getProvinecs(), HttpStatus.OK);
    }

    @GetMapping(value = "/getFonciers")
    public ResponseEntity<?> getFonciers(){
        return new ResponseEntity<>(this.service.getFonciers(), HttpStatus.OK);
    }

    @GetMapping(value = "/getNiveau")
    public ResponseEntity<?> getNiveau(){ return new ResponseEntity<>(this.service.getNiveau(), HttpStatus.OK);
    }


    @GetMapping(value = "/getAllProjet")
    public ResponseEntity<?> getAllProjet(){ return new ResponseEntity<>(this.service.getAllProjet(), HttpStatus.OK);
    }

    @GetMapping(value = "/helloword")
    public String hellow(){
        return " bonjour tous le monde test 08 ";
    }

    @GetMapping(value = "/bonjour")
    public String hellow02(){
        return " bonjour tous le monde ";
    }


}
