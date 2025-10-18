package dz.tarbiya.madrassa.adapter.out.jpa.inscription;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscription")
public class InscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscription;
    
    @Column(name = "id_eleve")
    private Long idEleve;
    
    @Column(name = "id_classe")
    private Long idClasse;
    
    @Column(name = "date_inscription")
    private LocalDate dateInscription;
    
    @Column(name = "date_fin")
    private LocalDate dateFin;
    
    private String statut;
    private String commentaire;

    // Constructeur par défaut
    public InscriptionEntity() {}

    // Getters et setters
    public Long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Long idInscription) {
        this.idInscription = idInscription;
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

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}