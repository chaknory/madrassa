package dz.tarbiya.madrassa.adapter.in.rest;

import dz.tarbiya.madrassa.application.service.EleveService;
import dz.tarbiya.madrassa.domain.model.Eleve;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eleves")
public class EleveController {
    private final EleveService service;

    public EleveController(EleveService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Eleve>> getAll() {
        long startTime = System.currentTimeMillis();
        System.out.println("🔄 Controller: Début de getAll() - " + new java.util.Date());
        
        List<Eleve> eleves = service.findAll();
        
        long endTime = System.currentTimeMillis();
        System.out.println("✅ Controller: Fin de getAll() - " + eleves.size() + " élèves - Temps: " + (endTime - startTime) + "ms");
        
        return ResponseEntity.ok(eleves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getById(@PathVariable Long id) {
        Eleve eleve = service.findById(id);
        return eleve != null ? ResponseEntity.ok(eleve) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Eleve> create(@RequestBody Eleve eleve) {
        Eleve created = service.save(eleve);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
