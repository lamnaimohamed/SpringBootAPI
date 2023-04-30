package com.example.demo.Service;

import com.example.demo.Dao.*;
import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {


    private PersonnelRepositroy personnelRepositroy;
    private Projet_Repo projetRepository;

    private FoncierRepo foncierRepo;
    private ProvinceRepo provinceRepo;
    private NiveauRepo niveauRepo;

    @Autowired
    public Service(PersonnelRepositroy personnelRepositroy, Projet_Repo projetRepository, FoncierRepo foncierRepo, ProvinceRepo provinceRepo, NiveauRepo niveauRepo) {
        this.personnelRepositroy = personnelRepositroy;
        this.projetRepository = projetRepository;
        this.foncierRepo = foncierRepo;
        this.provinceRepo = provinceRepo;
        this.niveauRepo = niveauRepo;
    }

    public List<Projet> getAll(){
        return this.projetRepository.findAll();
    }
    public List<Province> getProvinecs(){
        return this.provinceRepo.findAll();
    }
        public List<Foncier> getFonciers(){
        return this.foncierRepo.findAll();
    }

    public List<Niveau> getNiveau(){
        return this.niveauRepo.findAll();
    }
    public List<Projet> getAllProjet(){
        return this.projetRepository.findAll();
    }



    public Projet saveProjet(Projet projet){
        Projet p = this.projetRepository.save(projet);
        p.setSections(projet.getSections());
        p.setLots(projet.getLots());
        return this.projetRepository.save(p);

    }


    public void saveGeom(PersistgeomSections projet){
        try{
             this.projetRepository.saveGeom(projet.getSection(),projet.getGeometry());
        }catch ( Exception e ){
            System.out.println(e);
        }

    }

    public Personnel ajoutPer(){
        return this.personnelRepositroy.save(Personnel.builder().name("mohammed").data("achraf").build());
    }
}
