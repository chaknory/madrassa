package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.AbsenceService;
import dz.tarbiya.madrassa.domain.model.Absence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {
    private final AbsenceService service;
    public AbsenceController(AbsenceService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Absence>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Absence> getById(@PathVariable Long id) {
        Absence absence = service.findById(id);
        return absence != null ? ResponseEntity.ok(absence) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Absence> create(@RequestBody Absence absence) {
        Absence created = service.save(absence);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
