package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.CoursService;
import dz.tarbiya.madrassa.domain.model.Cours;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {
    private final CoursService service;
    public CoursController(CoursService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Cours>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Cours> getById(@PathVariable Long id) {
        Cours cours = service.findById(id);
        return cours != null ? ResponseEntity.ok(cours) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Cours> create(@RequestBody Cours cours) {
        Cours created = service.save(cours);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
