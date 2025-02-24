package com.stage.repository;

import com.stage.entity.Stage;
import com.stage.entity.EtatStage;
import com.stage.entity.TypeStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Long> {

    // Recherche par intitulé
    List<Stage> findByIntituleContaining(String intitule);

    // Recherche par technologies
    List<Stage> findByTechnologiesEtOutilsContaining(String technologies);

    // Recherche par état de stage
    List<Stage> findByEtatStage(EtatStage etatStage);

    // Recherche par type de stage
    List<Stage> findByTypeStage(TypeStage typeStage);

    // Recherche par date de début
    List<Stage> findByDateDebut(LocalDate dateDebut);

    // Recherche par date de fin
    List<Stage> findByDateFin(LocalDate dateFin);

    // Tri par date de début
    List<Stage> findAllByOrderByDateDebutAsc();

    // Tri par date de fin
    List<Stage> findAllByOrderByDateFinAsc();

    // Recherche combinée (exemple)
    @Query("SELECT s FROM Stage s WHERE s.dateDebut BETWEEN :startDate AND :endDate AND s.etatStage = :etatStage")
    List<Stage> findByDateDebutBetweenAndEtatStage(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("etatStage") EtatStage etatStage);
}