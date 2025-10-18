package dz.tarbiya.madrassa.adapter.out.jpa.periode;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "periode")
public class PeriodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriode;
    
    @Column(name = "id_annee")
    private Long idAnnee;
    
    private String libelle;
    
    @Column(name = "numero_periode")
    private Integer numeroPeriode;
    
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    
    @Column(name = "date_fin")
    private LocalDate dateFin;
    
    private Boolean cloturee;

    // Constructeur par défaut
    public PeriodeEntity() {}

    // Getters et Setters
    public Long getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Long idPeriode) {
        this.idPeriode = idPeriode;
    }

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

    public Integer getNumeroPeriode() {
        return numeroPeriode;
    }

    public void setNumeroPeriode(Integer numeroPeriode) {
        this.numeroPeriode = numeroPeriode;
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

    public Boolean getCloturee() {
        return cloturee;
    }

    public void setCloturee(Boolean cloturee) {
        this.cloturee = cloturee;
    }
}