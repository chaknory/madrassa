package dz.tarbiya.madrassa.adapter.in.rest;
import dz.tarbiya.madrassa.application.service.BulletinDetailService;
import dz.tarbiya.madrassa.domain.model.BulletinDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bulletins-detail")
public class BulletinDetailController {
    private final BulletinDetailService service;
    public BulletinDetailController(BulletinDetailService service) { this.service = service; }
    @GetMapping
    public ResponseEntity<List<BulletinDetail>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}")
    public ResponseEntity<BulletinDetail> getById(@PathVariable Long id) {
        BulletinDetail bulletinDetail = service.findById(id);
        return bulletinDetail != null ? ResponseEntity.ok(bulletinDetail) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<BulletinDetail> create(@RequestBody BulletinDetail bulletinDetail) {
        BulletinDetail created = service.save(bulletinDetail);
        return ResponseEntity.ok(created);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
