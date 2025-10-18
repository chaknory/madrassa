package dz.tarbiya.madrassa.adapter.out.jpa.cours;

import jakarta.persistence.*;

@Entity
@Table(name = "cours")
public class CoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;
    
    @Column(name = "id_classe")
    private Long idClasse;
    
    @Column(name = "id_matiere")
    private Long idMatiere;
    
    @Column(name = "id_enseignant")
    private Long idEnseignant;
    
    @Column(name = "id_annee")
    private Long idAnnee;
    
    @Column(name = "heures_semaine")
    private Double heuresSemaine;
    
    private Double coefficient;
    private String salle;

    // Constructeur par défaut
    public CoursEntity() {}

    // Getters et setters
    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Long getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Long idAnnee) {
        this.idAnnee = idAnnee;
    }

    public Double getHeuresSemaine() {
        return heuresSemaine;
    }

    public void setHeuresSemaine(Double heuresSemaine) {
        this.heuresSemaine = heuresSemaine;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
}