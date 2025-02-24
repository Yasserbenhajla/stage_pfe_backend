package com.stage.repository;

import com.stage.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    // Rechercher une entreprise par son nom exact
    Optional<Entreprise> findByNom(String nom);

    // Rechercher des entreprises dont le nom contient une chaîne de caractères (recherche partielle)
    List<Entreprise> findByNomContaining(String nom);
}