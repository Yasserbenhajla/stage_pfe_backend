package com.stage.repository;

import com.stage.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Rechercher un étudiant par email
    Optional<Etudiant> findByEmail(String email);

    // Rechercher des étudiants par filière
    List<Etudiant> findByFiliere(String filiere);

    // Rechercher des étudiants par spécialité
    List<Etudiant> findBySpecialite(String specialite);

    // Rechercher des étudiants par nom ou prénom
    List<Etudiant> findByNomContainingOrPrenomContaining(String nom, String prenom);

    // Rechercher un étudiant par téléphone
    Optional<Etudiant> findByTelephone(String telephone);

    // Compter le nombre d'étudiants dans une filière
    Long countByFiliere(String filiere);

    // Supprimer un étudiant par email
    void deleteByEmail(String email);

    // Rechercher des étudiants par domaine d'email (requête JPQL)
    @Query("SELECT e FROM Etudiant e WHERE e.email LIKE %:domain%")
    List<Etudiant> findByEmailDomain(@Param("domain") String domain);

    // Rechercher des étudiants par filière et spécialité (requête SQL native)
    @Query(value = "SELECT * FROM etudiants WHERE filiere = :filiere AND specialite = :specialite", nativeQuery = true)
    List<Etudiant> findByFiliereAndSpecialite(@Param("filiere") String filiere, @Param("specialite") String specialite);

    // Trier les étudiants par nom
    List<Etudiant> findAllByOrderByNomAsc();

    // Vérifier l'existence d'un étudiant par email
    boolean existsByEmail(String email);
}