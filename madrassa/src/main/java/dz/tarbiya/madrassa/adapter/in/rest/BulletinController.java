package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.BulletinService;
import dz.tarbiya.madrassa.domain.model.Bulletin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bulletins")
public class BulletinController {
    private final BulletinService service;
    public BulletinController(BulletinService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Bulletin>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Bulletin> getById(@PathVariable Long id) {
        Bulletin bulletin = service.findById(id);
        return bulletin != null ? ResponseEntity.ok(bulletin) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Bulletin> create(@RequestBody Bulletin bulletin) {
        Bulletin created = service.save(bulletin);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
