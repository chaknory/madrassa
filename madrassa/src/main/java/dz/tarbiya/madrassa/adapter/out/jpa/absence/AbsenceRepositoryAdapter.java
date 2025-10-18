package dz.tarbiya.madrassa.adapter.out.jpa.absence;

import dz.tarbiya.madrassa.application.port.AbsenceRepository;
import dz.tarbiya.madrassa.domain.model.Absence;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbsenceRepositoryAdapter implements AbsenceRepository {
    
    private final AbsenceJpaRepository jpaRepository;
    
    public AbsenceRepositoryAdapter(AbsenceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Absence save(Absence absence) {
        AbsenceEntity entity = toEntity(absence);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Absence> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Absence findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Absence toDomain(AbsenceEntity entity) {
        return new Absence(
            entity.getIdAbsence(),
            entity.getIdEleve(),
            entity.getIdCours(),
            entity.getDateAbsence(),
            entity.getHeureDebut(),
            entity.getHeureFin(),
            entity.getJustifie(),
            entity.getMotif(),
            entity.getPieceJustificative(),
            entity.getCommentaire(),
            entity.getDateSaisie()
        );
    }
    
    private AbsenceEntity toEntity(Absence absence) {
        AbsenceEntity entity = new AbsenceEntity();
        entity.setIdAbsence(absence.idAbsence());
        entity.setIdEleve(absence.idEleve());
        entity.setIdCours(absence.idCours());
        entity.setDateAbsence(absence.dateAbsence());
        entity.setHeureDebut(absence.heureDebut());
        entity.setHeureFin(absence.heureFin());
        entity.setJustifie(absence.justifie());
        entity.setMotif(absence.motif());
        entity.setPieceJustificative(absence.pieceJustificative());
        entity.setCommentaire(absence.commentaire());
        entity.setDateSaisie(absence.dateSaisie());
        return entity;
    }
}