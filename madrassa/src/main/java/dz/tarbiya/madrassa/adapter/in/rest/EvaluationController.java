package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.EvaluationService;
import dz.tarbiya.madrassa.domain.model.Evaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {
    private final EvaluationService service;
    public EvaluationController(EvaluationService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Evaluation>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getById(@PathVariable Long id) {
        Evaluation evaluation = service.findById(id);
        return evaluation != null ? ResponseEntity.ok(evaluation) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Evaluation> create(@RequestBody Evaluation evaluation) {
        Evaluation created = service.save(evaluation);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
