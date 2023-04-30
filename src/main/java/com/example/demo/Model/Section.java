package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_section", nullable = false)
    private Long id_section;

    @Transient
    private String geom;



    @JsonIgnoreProperties({"sections"})
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "projet")
    private Projet projet;



    @JsonIgnoreProperties({"sections"})
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "province")
    private Province province;

}
