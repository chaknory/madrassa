package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Note;
import java.util.List;

public interface NoteRepository {
    Note save(Note note);
    List<Note> findAll();
    Note findById(Long id);
    void deleteById(Long id);
}
