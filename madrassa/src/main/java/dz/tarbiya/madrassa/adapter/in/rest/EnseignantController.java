package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.EnseignantService;
import dz.tarbiya.madrassa.domain.model.Enseignant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {
    private final EnseignantService service;
    public EnseignantController(EnseignantService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Enseignant>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getById(@PathVariable Long id) {
        Enseignant enseignant = service.findById(id);
        return enseignant != null ? ResponseEntity.ok(enseignant) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Enseignant> create(@RequestBody Enseignant enseignant) {
        Enseignant created = service.save(enseignant);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
