package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.TypeEvaluationService;
import dz.tarbiya.madrassa.domain.model.TypeEvaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/types-evaluation")
public class TypeEvaluationController {
    private final TypeEvaluationService service;
    public TypeEvaluationController(TypeEvaluationService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<TypeEvaluation>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<TypeEvaluation> getById(@PathVariable Long id) {
        TypeEvaluation typeEvaluation = service.findById(id);
        return typeEvaluation != null ? ResponseEntity.ok(typeEvaluation) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<TypeEvaluation> create(@RequestBody TypeEvaluation typeEvaluation) {
        TypeEvaluation created = service.save(typeEvaluation);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
