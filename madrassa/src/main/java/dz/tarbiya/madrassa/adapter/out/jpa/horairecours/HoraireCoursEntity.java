package dz.tarbiya.madrassa.adapter.out.jpa.horairecours;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horaire_cours")
public class HoraireCoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHoraire;
    
    @Column(name = "id_cours")
    private Long idCours;
    
    @Column(name = "jour_semaine")
    private String jourSemaine;
    
    @Column(name = "heure_debut")
    private LocalTime heureDebut;
    
    @Column(name = "heure_fin")
    private LocalTime heureFin;
    
    private String salle;

    // Constructeur par défaut
    public HoraireCoursEntity() {}

    // Getters et setters
    public Long getIdHoraire() {
        return idHoraire;
    }

    public void setIdHoraire(Long idHoraire) {
        this.idHoraire = idHoraire;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public String getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(String jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
}