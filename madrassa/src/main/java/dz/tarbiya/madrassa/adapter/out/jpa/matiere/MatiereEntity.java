package dz.tarbiya.madrassa.adapter.out.jpa.matiere;

import jakarta.persistence.*;

@Entity
@Table(name = "matiere")
public class MatiereEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatiere;
    
    private String code;
    private String libelle;
    private String description;
    private Double coefficient;
    private String couleur;
    private Boolean actif;

    // Constructeur par défaut
    public MatiereEntity() {}

    // Getters et setters
    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}