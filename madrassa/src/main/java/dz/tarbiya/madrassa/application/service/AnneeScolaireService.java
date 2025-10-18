package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import dz.tarbiya.madrassa.application.port.AnneeScolaireRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnneeScolaireService {
    private final AnneeScolaireRepository repository;
    public AnneeScolaireService(AnneeScolaireRepository repository) { this.repository = repository; }
    public AnneeScolaire save(AnneeScolaire anneeScolaire) { return repository.save(anneeScolaire); }
    public List<AnneeScolaire> findAll() { return repository.findAll(); }
    public AnneeScolaire findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
    
    // Récupérer l'année scolaire active
    public AnneeScolaire findAnneeActive() {
        return repository.findByActiveTrue();
    }
    
    // Activer une année scolaire (désactive les autres)
    public AnneeScolaire activerAnnee(Long id) {
        // Désactiver toutes les années
        List<AnneeScolaire> toutesAnnees = repository.findAll();
        for (AnneeScolaire annee : toutesAnnees) {
            if (annee.active()) {
                // Créer une nouvelle instance avec active = false
                AnneeScolaire anneeDesactivee = new AnneeScolaire(
                    annee.idAnnee(),
                    annee.libelle(),
                    annee.dateDebut(),
                    annee.dateFin(),
                    false
                );
                repository.save(anneeDesactivee);
            }
        }
        
        // Activer l'année demandée
        AnneeScolaire anneeAActiver = repository.findById(id);
        if (anneeAActiver != null) {
            // Créer une nouvelle instance avec active = true
            AnneeScolaire anneeActivee = new AnneeScolaire(
                anneeAActiver.idAnnee(),
                anneeAActiver.libelle(),
                anneeAActiver.dateDebut(),
                anneeAActiver.dateFin(),
                true
            );
            return repository.save(anneeActivee);
        }
        return null;
    }
}
