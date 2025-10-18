package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.InscriptionService;
import dz.tarbiya.madrassa.domain.model.Inscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {
    private final InscriptionService service;
    public InscriptionController(InscriptionService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Inscription>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getById(@PathVariable Long id) {
        Inscription inscription = service.findById(id);
        return inscription != null ? ResponseEntity.ok(inscription) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Inscription> create(@RequestBody Inscription inscription) {
        Inscription created = service.save(inscription);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
