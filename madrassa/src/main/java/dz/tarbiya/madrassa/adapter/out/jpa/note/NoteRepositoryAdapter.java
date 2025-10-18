package dz.tarbiya.madrassa.adapter.out.jpa.note;

import dz.tarbiya.madrassa.application.port.NoteRepository;
import dz.tarbiya.madrassa.domain.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteRepositoryAdapter implements NoteRepository {
    
    private final NoteJpaRepository jpaRepository;
    
    public NoteRepositoryAdapter(NoteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Note save(Note note) {
        NoteEntity entity = toEntity(note);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Note> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Note findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Note toDomain(NoteEntity entity) {
        return new Note(
            entity.getIdNote(),
            entity.getIdEvaluation(),
            entity.getIdEleve(),
            entity.getValeur(),
            entity.getAbsent(),
            entity.getDispense(),
            entity.getAppreciation(),
            entity.getDateSaisie(),
            entity.getDateModification()
        );
    }
    
    private NoteEntity toEntity(Note note) {
        NoteEntity entity = new NoteEntity();
        entity.setIdNote(note.idNote());
        entity.setIdEvaluation(note.idEvaluation());
        entity.setIdEleve(note.idEleve());
        entity.setValeur(note.valeur());
        entity.setAbsent(note.absent());
        entity.setDispense(note.dispense());
        entity.setAppreciation(note.appreciation());
        entity.setDateSaisie(note.dateSaisie());
        entity.setDateModification(note.dateModification());
        return entity;
    }
}