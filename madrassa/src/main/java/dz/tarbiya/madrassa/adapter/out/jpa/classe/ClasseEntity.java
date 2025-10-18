package dz.tarbiya.madrassa.adapter.out.jpa.classe;

import jakarta.persistence.*;

@Entity
@Table(name = "classe")
public class ClasseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse;
    
    @Column(name = "id_annee")
    private Long idAnnee;
    
    @Column(name = "id_niveau")
    private Long idNiveau;
    
    @Column(name = "id_enseignant_principal")
    private Long idEnseignantPrincipal;
    
    @Column(name = "nom_classe")
    private String nomClasse;
    
    @Column(name = "effectif_max")
    private Integer effectifMax;
    
    private String salle;
    private String commentaire;

    // Constructeur par défaut
    public ClasseEntity() {}

    // Getters et setters
    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public Long getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Long idAnnee) {
        this.idAnnee = idAnnee;
    }

    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Long getIdEnseignantPrincipal() {
        return idEnseignantPrincipal;
    }

    public void setIdEnseignantPrincipal(Long idEnseignantPrincipal) {
        this.idEnseignantPrincipal = idEnseignantPrincipal;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Integer getEffectifMax() {
        return effectifMax;
    }

    public void setEffectifMax(Integer effectifMax) {
        this.effectifMax = effectifMax;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}