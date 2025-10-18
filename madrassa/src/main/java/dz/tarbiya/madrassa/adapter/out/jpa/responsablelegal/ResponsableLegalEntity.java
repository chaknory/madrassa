package dz.tarbiya.madrassa.adapter.out.jpa.responsablelegal;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "responsable_legal")
public class ResponsableLegalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsable;
    
    private String nom;
    private String prenom;
    private String telephone;
    
    @Column(name = "telephone_mobile")
    private String telephoneMobile;
    
    private String email;
    private String adresse;
    private String profession;
    
    @Column(name = "lien_parente")
    private String lienParente;
    
    @Column(name = "contact_urgence")
    private Boolean contactUrgence;
    
    @Column(name = "autorise_sortie")
    private Boolean autoriseSortie;
    
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    // Constructeur par défaut
    public ResponsableLegalEntity() {}

    // Getters et Setters
    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public Boolean getContactUrgence() {
        return contactUrgence;
    }

    public void setContactUrgence(Boolean contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public Boolean getAutoriseSortie() {
        return autoriseSortie;
    }

    public void setAutoriseSortie(Boolean autoriseSortie) {
        this.autoriseSortie = autoriseSortie;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}