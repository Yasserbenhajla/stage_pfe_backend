package com.stage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "encadrants_academiques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EncadrantAcademique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String qualite;  // Fonction de l'encadrant (Professeur, Maître de Conférences...)

    @Column(unique = true, nullable = false)
    private String email;
}
