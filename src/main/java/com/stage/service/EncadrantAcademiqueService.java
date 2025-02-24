package com.stage.service;

import com.stage.entity.EncadrantAcademique;
import com.stage.repository.EncadrantAcademiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncadrantAcademiqueService {

    @Autowired
    private EncadrantAcademiqueRepository encadrantAcademiqueRepository;

    // Ajouter un encadrant académique
    public EncadrantAcademique addEncadrantAcademique(EncadrantAcademique encadrantAcademique) {
        return encadrantAcademiqueRepository.save(encadrantAcademique);
    }

    // Récupérer tous les encadrants académiques
    public List<EncadrantAcademique> getAllEncadrantsAcademiques() {
        return encadrantAcademiqueRepository.findAll();
    }

    // Récupérer un encadrant académique par son ID
    public Optional<EncadrantAcademique> getEncadrantAcademiqueById(Long id) {
        return encadrantAcademiqueRepository.findById(id);
    }

    // Modifier un encadrant académique
    public EncadrantAcademique updateEncadrantAcademique(Long id, EncadrantAcademique encadrantAcademiqueDetails) {
        EncadrantAcademique encadrantAcademique = encadrantAcademiqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encadrant académique non trouvé avec l'ID : " + id));
        encadrantAcademique.setNom(encadrantAcademiqueDetails.getNom());
        encadrantAcademique.setPrenom(encadrantAcademiqueDetails.getPrenom());
        encadrantAcademique.setQualite(encadrantAcademiqueDetails.getQualite());
        encadrantAcademique.setEmail(encadrantAcademiqueDetails.getEmail());
        return encadrantAcademiqueRepository.save(encadrantAcademique);
    }

    // Supprimer un encadrant académique
    public void deleteEncadrantAcademique(Long id) {
        encadrantAcademiqueRepository.deleteById(id);
    }

    // Rechercher un encadrant académique par email
    public Optional<EncadrantAcademique> findByEmail(String email) {
        return encadrantAcademiqueRepository.findByEmail(email);
    }

    // Rechercher des encadrants académiques par nom
    public List<EncadrantAcademique> findByNom(String nom) {
        return encadrantAcademiqueRepository.findByNom(nom);
    }

    // Rechercher des encadrants académiques par prénom
    public List<EncadrantAcademique> findByPrenom(String prenom) {
        return encadrantAcademiqueRepository.findByPrenom(prenom);
    }

    // Rechercher des encadrants académiques par qualité
    public List<EncadrantAcademique> findByQualite(String qualite) {
        return encadrantAcademiqueRepository.findByQualite(qualite);
    }

    // Rechercher des encadrants académiques par nom ou prénom
    public List<EncadrantAcademique> findByNomContainingOrPrenomContaining(String nom, String prenom) {
        return encadrantAcademiqueRepository.findByNomContainingOrPrenomContaining(nom, prenom);
    }

    // Rechercher des encadrants académiques par nom et qualité
    public List<EncadrantAcademique> findByNomAndQualite(String nom, String qualite) {
        return encadrantAcademiqueRepository.findByNomAndQualite(nom, qualite);
    }

    // Compter le nombre d'encadrants académiques par qualité
    public Long countByQualite(String qualite) {
        return encadrantAcademiqueRepository.countByQualite(qualite);
    }

    // Supprimer un encadrant académique par email
    public void deleteByEmail(String email) {
        encadrantAcademiqueRepository.deleteByEmail(email);
    }

    // Rechercher des encadrants académiques par domaine d'email
    public List<EncadrantAcademique> findByEmailDomain(String domain) {
        return encadrantAcademiqueRepository.findByEmailDomain(domain);
    }

    // Rechercher des encadrants académiques par qualité et prénom
    public List<EncadrantAcademique> findByQualiteAndPrenom(String qualite, String prenom) {
        return encadrantAcademiqueRepository.findByQualiteAndPrenom(qualite, prenom);
    }

    // Trier les encadrants académiques par nom
    public List<EncadrantAcademique> findAllByOrderByNomAsc() {
        return encadrantAcademiqueRepository.findAllByOrderByNomAsc();
    }

    // Vérifier l'existence d'un encadrant académique par email
    public boolean existsByEmail(String email) {
        return encadrantAcademiqueRepository.existsByEmail(email);
    }
}