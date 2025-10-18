package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.NiveauService;
import dz.tarbiya.madrassa.domain.model.Niveau;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/niveaux")
public class NiveauController {
    private final NiveauService service;
    public NiveauController(NiveauService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Niveau>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Niveau> getById(@PathVariable Long id) {
        Niveau niveau = service.findById(id);
        return niveau != null ? ResponseEntity.ok(niveau) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Niveau> create(@RequestBody Niveau niveau) {
        Niveau created = service.save(niveau);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
