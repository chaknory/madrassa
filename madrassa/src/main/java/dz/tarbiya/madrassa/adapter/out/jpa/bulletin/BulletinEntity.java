package dz.tarbiya.madrassa.adapter.out.jpa.bulletin;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bulletin")
public class BulletinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBulletin;
    
    @Column(name = "id_eleve")
    private Long idEleve;
    
    @Column(name = "id_classe")
    private Long idClasse;
    
    @Column(name = "id_periode")
    private Long idPeriode;
    
    @Column(name = "moyenne_generale")
    private Double moyenneGenerale;
    
    private Integer rang;
    
    @Column(name = "total_eleves")
    private Integer totalEleves;
    
    @Column(name = "nb_absences")
    private Integer nbAbsences;
    
    @Column(name = "nb_retards")
    private Integer nbRetards;
    
    @Column(name = "appreciation_generale")
    private String appreciationGenerale;
    
    @Column(name = "decision_conseil")
    private String decisionConseil;
    
    @Column(name = "date_conseil")
    private LocalDate dateConseil;
    
    @Column(name = "date_generation")
    private LocalDateTime dateGeneration;
    
    private Boolean valide;
    
    @Column(name = "date_validation")
    private LocalDateTime dateValidation;

    // Constructeur par défaut
    public BulletinEntity() {}

    // Getters et setters
    public Long getIdBulletin() {
        return idBulletin;
    }

    public void setIdBulletin(Long idBulletin) {
        this.idBulletin = idBulletin;
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public Long getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Long idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Double getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(Double moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Integer getTotalEleves() {
        return totalEleves;
    }

    public void setTotalEleves(Integer totalEleves) {
        this.totalEleves = totalEleves;
    }

    public Integer getNbAbsences() {
        return nbAbsences;
    }

    public void setNbAbsences(Integer nbAbsences) {
        this.nbAbsences = nbAbsences;
    }

    public Integer getNbRetards() {
        return nbRetards;
    }

    public void setNbRetards(Integer nbRetards) {
        this.nbRetards = nbRetards;
    }

    public String getAppreciationGenerale() {
        return appreciationGenerale;
    }

    public void setAppreciationGenerale(String appreciationGenerale) {
        this.appreciationGenerale = appreciationGenerale;
    }

    public String getDecisionConseil() {
        return decisionConseil;
    }

    public void setDecisionConseil(String decisionConseil) {
        this.decisionConseil = decisionConseil;
    }

    public LocalDate getDateConseil() {
        return dateConseil;
    }

    public void setDateConseil(LocalDate dateConseil) {
        this.dateConseil = dateConseil;
    }

    public LocalDateTime getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(LocalDateTime dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public LocalDateTime getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(LocalDateTime dateValidation) {
        this.dateValidation = dateValidation;
    }
}