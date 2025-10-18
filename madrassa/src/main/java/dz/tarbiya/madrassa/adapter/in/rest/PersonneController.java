package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.PersonneService;
import dz.tarbiya.madrassa.domain.model.Personne;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {
    private final PersonneService service;
    public PersonneController(PersonneService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Personne>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getById(@PathVariable Long id) {
        Personne personne = service.findById(id);
        return personne != null ? ResponseEntity.ok(personne) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Personne> create(@RequestBody Personne personne) {
        Personne created = service.save(personne);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
