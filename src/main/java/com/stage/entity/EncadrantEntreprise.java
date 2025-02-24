package com.stage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "encadrant_entreprise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EncadrantEntreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String qualite;
    private String email;
    private String telephone;

    // Clé étrangère pour l'entreprise
    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise; // Référence à l'entité Entreprise
}
