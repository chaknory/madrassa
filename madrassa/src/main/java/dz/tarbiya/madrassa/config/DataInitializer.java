package dz.tarbiya.madrassa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Composant responsable de l'initialisation des données au démarrage de l'application.
 * Exécute le script d'insertion de données seulement si la base est vide.
 */
@Component
public class DataInitializer {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Méthode exécutée automatiquement après le démarrage complet de l'application.
     * Vérifie si des données existent déjà et insère les données de test si nécessaire.
     */
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeData() {
        try {
            // Vérifier si des données existent déjà
            Integer eleveCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM eleve", Integer.class);
            
            if (eleveCount != null && eleveCount > 0) {
                logger.info("Des données existent déjà dans la base ({} élèves). Aucune initialisation nécessaire.", eleveCount);
                return;
            }
            
            logger.info("Base de données vide détectée. Initialisation des données de test...");
            
            // Lire le script SQL depuis les ressources
            ClassPathResource resource = new ClassPathResource("data-insertion-script.sql");
            String sqlScript;
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                sqlScript = reader.lines().collect(Collectors.joining("\n"));
            }
            
            logger.info("Script SQL lu, taille: {} caractères", sqlScript.length());
            
            // Diviser le script en instructions individuelles (simple split sur ';')
            String[] sqlStatements = sqlScript.split(";");
            
            logger.info("Nombre d'instructions trouvées: {}", sqlStatements.length);
            
            int executedStatements = 0;
            for (int i = 0; i < sqlStatements.length; i++) {
                String cleanStatement = sqlStatements[i].trim();
                
                // Ignorer les commentaires et les lignes vides
                if (!cleanStatement.isEmpty() && 
                    !cleanStatement.startsWith("--") && 
                    cleanStatement.toUpperCase().startsWith("INSERT")) {
                    
                    try {
                        logger.debug("Exécution instruction {}: {}", i, cleanStatement.substring(0, Math.min(50, cleanStatement.length())));
                        jdbcTemplate.execute(cleanStatement);
                        executedStatements++;
                    } catch (Exception e) {
                        logger.warn("Erreur lors de l'exécution de l'instruction {} SQL: {}", i, cleanStatement.substring(0, Math.min(80, cleanStatement.length())));
                        logger.debug("Détail de l'erreur: ", e);
                    }
                }
            }
            
            // Vérifier les résultats
            Integer finalEleveCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM eleve", Integer.class);
            Integer inscriptionCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM inscription", Integer.class);
            Integer noteCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM note", Integer.class);
            
            logger.info("✅ Initialisation des données terminée avec succès !");
            logger.info("📊 Résultat: {} instructions exécutées", executedStatements);
            logger.info("👥 {} élèves inscrits", finalEleveCount);
            logger.info("📝 {} inscriptions actives", inscriptionCount);
            logger.info("📋 {} notes attribuées", noteCount);
            
        } catch (Exception e) {
            logger.error("❌ Erreur lors de l'initialisation des données", e);
            throw new RuntimeException("Échec de l'initialisation des données", e);
        }
    }
}