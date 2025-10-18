package dz.tarbiya.madrassa.adapter.out.jpa.inscription;

import dz.tarbiya.madrassa.application.port.InscriptionRepository;
import dz.tarbiya.madrassa.domain.model.Inscription;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InscriptionRepositoryAdapter implements InscriptionRepository {
    
    private final InscriptionJpaRepository jpaRepository;
    
    public InscriptionRepositoryAdapter(InscriptionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Inscription save(Inscription inscription) {
        InscriptionEntity entity = toEntity(inscription);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Inscription> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Inscription findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Inscription toDomain(InscriptionEntity entity) {
        return new Inscription(
            entity.getIdInscription(),
            entity.getIdEleve(),
            entity.getIdClasse(),
            entity.getDateInscription(),
            entity.getDateFin(),
            entity.getStatut(),
            entity.getCommentaire()
        );
    }
    
    private InscriptionEntity toEntity(Inscription inscription) {
        InscriptionEntity entity = new InscriptionEntity();
        entity.setIdInscription(inscription.idInscription());
        entity.setIdEleve(inscription.idEleve());
        entity.setIdClasse(inscription.idClasse());
        entity.setDateInscription(inscription.dateInscription());
        entity.setDateFin(inscription.dateFin());
        entity.setStatut(inscription.statut());
        entity.setCommentaire(inscription.commentaire());
        return entity;
    }
}