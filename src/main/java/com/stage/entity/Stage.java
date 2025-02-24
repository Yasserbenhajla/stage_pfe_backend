package com.stage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "stages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EtatSujet etatSujet; // ENUM : VALIDE, NON_VALIDE

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Column(columnDefinition = "TEXT")
    private String technologiesEtOutils;

    @Enumerated(EnumType.STRING)
    private EtatStage etatStage; // ENUM : EN_COURS, SOUTENU, ANNULE

    private String lieuStage;
    private String paysStage;

    // Relations

    @ManyToOne
    @JoinColumn(name = "encadrant_academique_id")
    private EncadrantAcademique encadrantAcademique;

    @ManyToOne
    @JoinColumn(name = "encadrant_entreprise_id")
    private EncadrantEntreprise encadrantEntreprise;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "type_stage_id", nullable = false)
    private TypeStage typeStage;
}
