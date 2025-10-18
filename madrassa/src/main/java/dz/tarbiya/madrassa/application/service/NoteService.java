package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Note;
import dz.tarbiya.madrassa.application.port.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository repository;
    public NoteService(NoteRepository repository) { this.repository = repository; }
    public Note save(Note note) { return repository.save(note); }
    public List<Note> findAll() { return repository.findAll(); }
    public Note findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
