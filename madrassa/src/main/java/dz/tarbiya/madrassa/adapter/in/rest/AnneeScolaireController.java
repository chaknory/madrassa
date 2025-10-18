package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.AnneeScolaireService;
import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/annees-scolaires")
public class AnneeScolaireController {
    private final AnneeScolaireService service;
    public AnneeScolaireController(AnneeScolaireService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<AnneeScolaire>> getAll() { return ResponseEntity.ok(service.findAll()); }
    
    @GetMapping("/active")
    public ResponseEntity<AnneeScolaire> getActive() {
        AnneeScolaire anneeActive = service.findAnneeActive();
        return anneeActive != null ? ResponseEntity.ok(anneeActive) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AnneeScolaire> getById(@PathVariable Long id) {
        AnneeScolaire anneeScolaire = service.findById(id);
        return anneeScolaire != null ? ResponseEntity.ok(anneeScolaire) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<AnneeScolaire> create(@RequestBody AnneeScolaire anneeScolaire) {
        AnneeScolaire created = service.save(anneeScolaire);
        return ResponseEntity.ok(created);
    }
    
    @PatchMapping("/{id}/activer")
    public ResponseEntity<AnneeScolaire> activerAnnee(@PathVariable Long id) {
        AnneeScolaire anneeActivee = service.activerAnnee(id);
        return anneeActivee != null ? ResponseEntity.ok(anneeActivee) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
