package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.HoraireCoursService;
import dz.tarbiya.madrassa.domain.model.HoraireCours;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/horaires-cours")
public class HoraireCoursController {
    private final HoraireCoursService service;
    public HoraireCoursController(HoraireCoursService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<HoraireCours>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<HoraireCours> getById(@PathVariable Long id) {
        HoraireCours horaireCours = service.findById(id);
        return horaireCours != null ? ResponseEntity.ok(horaireCours) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<HoraireCours> create(@RequestBody HoraireCours horaireCours) {
        HoraireCours created = service.save(horaireCours);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
