package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.MatiereService;
import dz.tarbiya.madrassa.domain.model.Matiere;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matieres")
public class MatiereController {
    private final MatiereService service;
    public MatiereController(MatiereService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Matiere>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getById(@PathVariable Long id) {
        Matiere matiere = service.findById(id);
        return matiere != null ? ResponseEntity.ok(matiere) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Matiere> create(@RequestBody Matiere matiere) {
        Matiere created = service.save(matiere);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
