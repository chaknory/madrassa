package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.ResponsableLegalService;
import dz.tarbiya.madrassa.domain.model.ResponsableLegal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/responsables-legaux")
public class ResponsableLegalController {
    private final ResponsableLegalService service;
    public ResponsableLegalController(ResponsableLegalService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<ResponsableLegal>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<ResponsableLegal> getById(@PathVariable Long id) {
        ResponsableLegal responsableLegal = service.findById(id);
        return responsableLegal != null ? ResponseEntity.ok(responsableLegal) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<ResponsableLegal> create(@RequestBody ResponsableLegal responsableLegal) {
        ResponsableLegal created = service.save(responsableLegal);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
