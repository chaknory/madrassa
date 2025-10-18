package dz.tarbiya.madrassa.adapter.out.jpa.typeevaluation;

import jakarta.persistence.*;

@Entity
@Table(name = "type_evaluation")
public class TypeEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeEval;
    
    private String code;
    private String libelle;
    private Double coefficient;
    
    @Column(name = "compte_moyenne")
    private Boolean compteMoyenne;
    
    private String description;

    // Constructeur par défaut
    public TypeEvaluationEntity() {}

    // Getters et Setters
    public Long getIdTypeEval() {
        return idTypeEval;
    }

    public void setIdTypeEval(Long idTypeEval) {
        this.idTypeEval = idTypeEval;
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

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Boolean getCompteMoyenne() {
        return compteMoyenne;
    }

    public void setCompteMoyenne(Boolean compteMoyenne) {
        this.compteMoyenne = compteMoyenne;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}