package dz.tarbiya.madrassa.adapter.out.jpa.retard;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "retard")
public class RetardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRetard;
    
    @Column(name = "id_eleve")
    private Long idEleve;
    
    @Column(name = "id_cours")
    private Long idCours;
    
    @Column(name = "date_retard")
    private LocalDate dateRetard;
    
    @Column(name = "heure_arrivee")
    private LocalTime heureArrivee;
    
    @Column(name = "duree_minutes")
    private Integer dureeMinutes;
    
    private Boolean justifie;
    private String motif;

    // Constructeur par défaut
    public RetardEntity() {}

    // Getters et Setters
    public Long getIdRetard() {
        return idRetard;
    }

    public void setIdRetard(Long idRetard) {
        this.idRetard = idRetard;
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public LocalDate getDateRetard() {
        return dateRetard;
    }

    public void setDateRetard(LocalDate dateRetard) {
        this.dateRetard = dateRetard;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public Integer getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(Integer dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public Boolean getJustifie() {
        return justifie;
    }

    public void setJustifie(Boolean justifie) {
        this.justifie = justifie;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}