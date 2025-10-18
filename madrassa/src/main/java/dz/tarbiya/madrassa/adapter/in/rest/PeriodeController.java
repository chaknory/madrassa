package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.PeriodeService;
import dz.tarbiya.madrassa.domain.model.Periode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/periodes")
public class PeriodeController {
    private final PeriodeService service;
    public PeriodeController(PeriodeService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Periode>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Periode> getById(@PathVariable Long id) {
        Periode periode = service.findById(id);
        return periode != null ? ResponseEntity.ok(periode) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Periode> create(@RequestBody Periode periode) {
        Periode created = service.save(periode);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
