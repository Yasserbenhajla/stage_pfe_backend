package com.stage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "types_stage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String intitule; // Exemple: Stage d'été, PFE, Initiation, Perfectionnement
}
