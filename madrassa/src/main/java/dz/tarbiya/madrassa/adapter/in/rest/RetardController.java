package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.RetardService;
import dz.tarbiya.madrassa.domain.model.Retard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/retards")
public class RetardController {
    private final RetardService service;
    public RetardController(RetardService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Retard>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Retard> getById(@PathVariable Long id) {
        Retard retard = service.findById(id);
        return retard != null ? ResponseEntity.ok(retard) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Retard> create(@RequestBody Retard retard) {
        Retard created = service.save(retard);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
