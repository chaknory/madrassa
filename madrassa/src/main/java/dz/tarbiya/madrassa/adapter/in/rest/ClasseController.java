package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.ClasseService;
import dz.tarbiya.madrassa.domain.model.Classe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {
    private final ClasseService service;
    public ClasseController(ClasseService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Classe>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(@PathVariable Long id) {
        Classe classe = service.findById(id);
        return classe != null ? ResponseEntity.ok(classe) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Classe> create(@RequestBody Classe classe) {
        Classe created = service.save(classe);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
