package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.PersonnelService;
import dz.tarbiya.madrassa.domain.model.Personnel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {
    private final PersonnelService service;
    public PersonnelController(PersonnelService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<Personnel>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<Personnel> getById(@PathVariable Long id) {
        Personnel personnel = service.findById(id);
        return personnel != null ? ResponseEntity.ok(personnel) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Personnel> create(@RequestBody Personnel personnel) {
        Personnel created = service.save(personnel);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
