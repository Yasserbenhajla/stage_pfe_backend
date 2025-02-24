package com.stage.repository;

import com.stage.entity.EncadrantAcademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EncadrantAcademiqueRepository extends JpaRepository<EncadrantAcademique, Long> {

    // Rechercher un encadrant académique par email
    Optional<EncadrantAcademique> findByEmail(String email);

    // Rechercher des encadrants académiques par nom
    List<EncadrantAcademique> findByNom(String nom);

    // Rechercher des encadrants académiques par prénom
    List<EncadrantAcademique> findByPrenom(String prenom);

    // Rechercher des encadrants académiques par qualité (fonction)
    List<EncadrantAcademique> findByQualite(String qualite);

    // Rechercher des encadrants académiques par nom ou prénom
    List<EncadrantAcademique> findByNomContainingOrPrenomContaining(String nom, String prenom);

    // Rechercher des encadrants académiques par nom et qualité
    List<EncadrantAcademique> findByNomAndQualite(String nom, String qualite);

    // Compter le nombre d'encadrants académiques par qualité
    Long countByQualite(String qualite);

    // Supprimer un encadrant académique par email
    void deleteByEmail(String email);

    // Rechercher des encadrants académiques dont l'email contient un domaine spécifique (requête JPQL)
    @Query("SELECT e FROM EncadrantAcademique e WHERE e.email LIKE %:domain%")
    List<EncadrantAcademique> findByEmailDomain(@Param("domain") String domain);

    // Rechercher des encadrants académiques par qualité et prénom (requête SQL native)
    @Query(value = "SELECT * FROM encadrants_academiques WHERE qualite = :qualite AND prenom = :prenom", nativeQuery = true)
    List<EncadrantAcademique> findByQualiteAndPrenom(@Param("qualite") String qualite, @Param("prenom") String prenom);

    // Trier les encadrants académiques par nom (ordre alphabétique)
    List<EncadrantAcademique> findAllByOrderByNomAsc();

    // Vérifier l'existence d'un encadrant académique par email
    boolean existsByEmail(String email);
}