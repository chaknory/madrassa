package dz.tarbiya.madrassa.adapter.out.jpa.anneescolaire;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "annee_scolaire")
public class AnneeScolaireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnee;
    
    private String libelle;
    
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    
    @Column(name = "date_fin")
    private LocalDate dateFin;
    
    private Boolean active;

    // Constructeur par défaut
    public AnneeScolaireEntity() {}

    // Getters et setters
    public Long getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Long idAnnee) {
        this.idAnnee = idAnnee;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}