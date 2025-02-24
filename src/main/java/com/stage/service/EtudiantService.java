package com.stage.service;

import com.stage.entity.Etudiant;
import com.stage.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    // Ajouter un étudiant
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // Récupérer un étudiant par son ID
    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    // Modifier un étudiant
    public Etudiant updateEtudiant(Long id, Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'ID : " + id));
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setEmail(etudiantDetails.getEmail());
        etudiant.setTelephone(etudiantDetails.getTelephone());
        etudiant.setFiliere(etudiantDetails.getFiliere());
        etudiant.setSpecialite(etudiantDetails.getSpecialite());
        return etudiantRepository.save(etudiant);
    }

    // Supprimer un étudiant
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    // Rechercher un étudiant par email
    public Optional<Etudiant> findByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }

    // Rechercher des étudiants par filière
    public List<Etudiant> findByFiliere(String filiere) {
        return etudiantRepository.findByFiliere(filiere);
    }

    // Rechercher des étudiants par spécialité
    public List<Etudiant> findBySpecialite(String specialite) {
        return etudiantRepository.findBySpecialite(specialite);
    }

    // Rechercher des étudiants par nom ou prénom
    public List<Etudiant> findByNomContainingOrPrenomContaining(String nom, String prenom) {
        return etudiantRepository.findByNomContainingOrPrenomContaining(nom, prenom);
    }

    // Rechercher un étudiant par téléphone
    public Optional<Etudiant> findByTelephone(String telephone) {
        return etudiantRepository.findByTelephone(telephone);
    }

    // Compter le nombre d'étudiants dans une filière
    public Long countByFiliere(String filiere) {
        return etudiantRepository.countByFiliere(filiere);
    }

    // Supprimer un étudiant par email
    public void deleteByEmail(String email) {
        etudiantRepository.deleteByEmail(email);
    }

    // Rechercher des étudiants par domaine d'email
    public List<Etudiant> findByEmailDomain(String domain) {
        return etudiantRepository.findByEmailDomain(domain);
    }

    // Rechercher des étudiants par filière et spécialité
    public List<Etudiant> findByFiliereAndSpecialite(String filiere, String specialite) {
        return etudiantRepository.findByFiliereAndSpecialite(filiere, specialite);
    }

    // Trier les étudiants par nom
    public List<Etudiant> findAllByOrderByNomAsc() {
        return etudiantRepository.findAllByOrderByNomAsc();
    }

    // Vérifier l'existence d'un étudiant par email
    public boolean existsByEmail(String email) {
        return etudiantRepository.existsByEmail(email);
    }
}