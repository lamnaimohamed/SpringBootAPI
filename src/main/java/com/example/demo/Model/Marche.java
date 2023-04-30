package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Marche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marche", nullable = false)
    private Long id_marche;

    private String numero_marche;
    private String objet;
    private String titulaire;
    private Double montant;
    private Date os_commencement;
    private Date dateOverturePlit;
    private String n_appel_offre;


    @JsonIgnoreProperties({"marche"})
    @OneToMany(mappedBy = "marche", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lot> lots = new ArrayList<>();
}

