package dz.tarbiya.madrassa.adapter.out.jpa.enseignant;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enseignant")
public class EnseignantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant;
    
    @Column(name = "id_personne")
    private Long idPersonne;
    
    @Column(name = "numero_employe")
    private String numeroEmploye;
    
    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;
    
    private String specialite;
    private String diplome;
    private String statut;
    
    @Column(name = "volume_horaire_hebdo")
    private Double volumeHoraireHebdo;
    
    private Boolean actif;

    // Constructeur par défaut
    public EnseignantEntity() {}

    // Getters et setters
    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
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

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Double getVolumeHoraireHebdo() {
        return volumeHoraireHebdo;
    }

    public void setVolumeHoraireHebdo(Double volumeHoraireHebdo) {
        this.volumeHoraireHebdo = volumeHoraireHebdo;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}