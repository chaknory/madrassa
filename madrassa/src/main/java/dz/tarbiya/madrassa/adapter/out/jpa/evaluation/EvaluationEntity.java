package dz.tarbiya.madrassa.adapter.out.jpa.evaluation;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evaluation")
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluation;

    @Column(name = "id_matiere")
    private Long idMatiere;

    @Column(name = "id_classe")
    private Long idClasse;

    @Column(name = "type")
    private String type;

    @Column(name = "date_evaluation")
    private LocalDateTime dateEvaluation;

    @Column(name = "coefficient")
    private Double coefficient;

    // Default constructor
    public EvaluationEntity() {}

    // Getters and setters
    public Long getIdEvaluation() { return idEvaluation; }
    public void setIdEvaluation(Long idEvaluation) { this.idEvaluation = idEvaluation; }
    public Long getIdMatiere() { return idMatiere; }
    public void setIdMatiere(Long idMatiere) { this.idMatiere = idMatiere; }
    public Long getIdClasse() { return idClasse; }
    public void setIdClasse(Long idClasse) { this.idClasse = idClasse; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDateTime getDateEvaluation() { return dateEvaluation; }
    public void setDateEvaluation(LocalDateTime dateEvaluation) { this.dateEvaluation = dateEvaluation; }
    public Double getCoefficient() { return coefficient; }
    public void setCoefficient(Double coefficient) { this.coefficient = coefficient; }
}
