package dz.tarbiya.madrassa.adapter.out.jpa.enseignant;

import dz.tarbiya.madrassa.application.port.EnseignantRepository;
import dz.tarbiya.madrassa.domain.model.Enseignant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnseignantRepositoryAdapter implements EnseignantRepository {
    
    private final EnseignantJpaRepository jpaRepository;
    
    public EnseignantRepositoryAdapter(EnseignantJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Enseignant save(Enseignant enseignant) {
        EnseignantEntity entity = toEntity(enseignant);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Enseignant> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Enseignant findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Enseignant toDomain(EnseignantEntity entity) {
        return new Enseignant(
            entity.getIdEnseignant(),
            entity.getIdPersonne(),
            entity.getNumeroEmploye(),
            entity.getDateEmbauche(),
            entity.getSpecialite(),
            entity.getDiplome(),
            entity.getStatut(),
            entity.getVolumeHoraireHebdo(),
            entity.getActif()
        );
    }
    
    private EnseignantEntity toEntity(Enseignant enseignant) {
        EnseignantEntity entity = new EnseignantEntity();
        entity.setIdEnseignant(enseignant.idEnseignant());
        entity.setIdPersonne(enseignant.idPersonne());
        entity.setNumeroEmploye(enseignant.numeroEmploye());
        entity.setDateEmbauche(enseignant.dateEmbauche());
        entity.setSpecialite(enseignant.specialite());
        entity.setDiplome(enseignant.diplome());
        entity.setStatut(enseignant.statut());
        entity.setVolumeHoraireHebdo(enseignant.volumeHoraireHebdo());
        entity.setActif(enseignant.actif());
        return entity;
    }
}