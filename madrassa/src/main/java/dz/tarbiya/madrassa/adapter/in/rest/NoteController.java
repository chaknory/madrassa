package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.NoteService;
import dz.tarbiya.madrassa.domain.model.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService service;
    public NoteController(NoteService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Note>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id) {
        Note note = service.findById(id);
        return note != null ? ResponseEntity.ok(note) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note) {
        Note created = service.save(note);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
