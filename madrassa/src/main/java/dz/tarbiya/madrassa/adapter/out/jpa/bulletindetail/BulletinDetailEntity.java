package dz.tarbiya.madrassa.adapter.out.jpa.bulletindetail;

import jakarta.persistence.*;

@Entity
@Table(name = "bulletin_detail")
public class BulletinDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBulletinDetail;
    
    @Column(name = "id_bulletin")
    private Long idBulletin;
    
    @Column(name = "id_matiere")
    private Long idMatiere;
    
    private Double moyenne;
    
    private Integer rang;
    
    @Column(name = "note_devoir_1")
    private Double noteDevoir1;
    
    @Column(name = "note_devoir_2")
    private Double noteDevoir2;
    
    @Column(name = "note_devoir_3")
    private Double noteDevoir3;
    
    @Column(name = "note_composition")
    private Double noteComposition;
    
    private String appreciation;
    
    @Column(name = "absence_heures")
    private Integer absenceHeures;
    
    @Column(name = "coefficient")
    private Double coefficient;

    // Constructeur par défaut
    public BulletinDetailEntity() {}

    // Getters et setters
    public Long getIdBulletinDetail() {
        return idBulletinDetail;
    }

    public void setIdBulletinDetail(Long idBulletinDetail) {
        this.idBulletinDetail = idBulletinDetail;
    }

    public Long getIdBulletin() {
        return idBulletin;
    }

    public void setIdBulletin(Long idBulletin) {
        this.idBulletin = idBulletin;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Double getNoteDevoir1() {
        return noteDevoir1;
    }

    public void setNoteDevoir1(Double noteDevoir1) {
        this.noteDevoir1 = noteDevoir1;
    }

    public Double getNoteDevoir2() {
        return noteDevoir2;
    }

    public void setNoteDevoir2(Double noteDevoir2) {
        this.noteDevoir2 = noteDevoir2;
    }

    public Double getNoteDevoir3() {
        return noteDevoir3;
    }

    public void setNoteDevoir3(Double noteDevoir3) {
        this.noteDevoir3 = noteDevoir3;
    }

    public Double getNoteComposition() {
        return noteComposition;
    }

    public void setNoteComposition(Double noteComposition) {
        this.noteComposition = noteComposition;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Integer getAbsenceHeures() {
        return absenceHeures;
    }

    public void setAbsenceHeures(Integer absenceHeures) {
        this.absenceHeures = absenceHeures;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
}