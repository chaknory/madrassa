package dz.tarbiya.madrassa.adapter.out.jpa.eleve;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eleve")
public class EleveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @Column(name = "numero_eleve")
    private String numeroEleve;
    // ... autres champs

    // Getters et setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String getNumeroEleve() {
        return numeroEleve;
    }
    
    public void setNumeroEleve(String numeroEleve) {
        this.numeroEleve = numeroEleve;
    }
}
