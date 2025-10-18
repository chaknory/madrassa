package dz.tarbiya.madrassa.adapter.out.jpa.niveau;

import jakarta.persistence.*;

@Entity
@Table(name = "niveau")
public class NiveauEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    
    private String code;
    private String libelle;
    private Integer ordre;
    private String cycle;

    // Constructeur par défaut
    public NiveauEntity() {}

    // Getters et setters
    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
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

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}