package dz.tarbiya.madrassa.adapter.out.jpa.note;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNote;
    
    @Column(name = "id_evaluation")
    private Long idEvaluation;
    
    @Column(name = "id_eleve")
    private Long idEleve;
    
    private Double valeur;
    private Boolean absent;
    private Boolean dispense;
    private String appreciation;
    
    @Column(name = "date_saisie")
    private LocalDateTime dateSaisie;
    
    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    // Constructeur par défaut
    public NoteEntity() {}

    // Getters et Setters
    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
    }

    public Long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Boolean getAbsent() {
        return absent;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public Boolean getDispense() {
        return dispense;
    }

    public void setDispense(Boolean dispense) {
        this.dispense = dispense;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public LocalDateTime getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(LocalDateTime dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }
}