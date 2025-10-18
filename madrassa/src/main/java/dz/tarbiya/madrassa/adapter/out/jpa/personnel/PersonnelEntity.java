package dz.tarbiya.madrassa.adapter.out.jpa.personnel;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "personnel")
public class PersonnelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    
    @Column(name = "id_personne")
    private Long idPersonne;
    
    @Column(name = "numero_employe")
    private String numeroEmploye;
    
    private String fonction;
    
    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;
    
    private String service;
    private Boolean actif;

    // Constructeur par défaut
    public PersonnelEntity() {}

    // Getters et Setters
    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNumeroEmploye() {
        return numeroEmploye;
    }

    public void setNumeroEmploye(String numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}