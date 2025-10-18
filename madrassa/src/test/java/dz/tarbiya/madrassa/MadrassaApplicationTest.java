package dz.tarbiya.madrassa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MadrassaApplicationTest {

    @Test
    void contextLoads() {
        // Test de base pour vérifier que le contexte Spring se charge correctement
        // avec tous les repositories et services
    }
}