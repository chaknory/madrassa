package dz.tarbiya.madrassa.application.service;

import dz.tarbiya.madrassa.application.port.EleveRepository;
import dz.tarbiya.madrassa.domain.model.Eleve;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EleveServiceTest {

    @Mock
    private EleveRepository eleveRepository;

    @InjectMocks
    private EleveService eleveService;

    private Eleve sampleEleve;

    @BeforeEach
    void setUp() {
        sampleEleve = new Eleve(
                1L,
                "Martin",
                "Alice",
                LocalDate.of(2010, 5, 15),
                "EL2024001"
        );
    }

    @Test
    void save_ShouldReturnSavedEleve() {
        // Given
        when(eleveRepository.save(any(Eleve.class))).thenReturn(sampleEleve);

        // When
        Eleve result = eleveService.save(sampleEleve);

        // Then
        assertThat(result).isEqualTo(sampleEleve);
        assertThat(result.nom()).isEqualTo("Martin");
        assertThat(result.prenom()).isEqualTo("Alice");
        assertThat(result.numeroEleve()).isEqualTo("EL2024001");
        verify(eleveRepository).save(sampleEleve);
    }

    @Test
    void findAll_ShouldReturnListOfEleves() {
        // Given
        Eleve eleve2 = new Eleve(2L, "Dupont", "Bob", LocalDate.of(2011, 3, 20), "EL2024002");
        List<Eleve> eleves = Arrays.asList(sampleEleve, eleve2);
        when(eleveRepository.findAll()).thenReturn(eleves);

        // When
        List<Eleve> result = eleveService.findAll();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(sampleEleve, eleve2);
        verify(eleveRepository).findAll();
    }

    @Test
    void findById_ShouldReturnEleve() {
        // Given
        Long eleveId = 1L;
        when(eleveRepository.findById(eleveId)).thenReturn(sampleEleve);

        // When
        Eleve result = eleveService.findById(eleveId);

        // Then
        assertThat(result).isEqualTo(sampleEleve);
        assertThat(result.dateNaissance()).isEqualTo(LocalDate.of(2010, 5, 15));
        verify(eleveRepository).findById(eleveId);
    }

    @Test
    void deleteById_ShouldCallRepositoryDelete() {
        // Given
        Long eleveId = 1L;

        // When
        eleveService.deleteById(eleveId);

        // Then
        verify(eleveRepository).deleteById(eleveId);
    }

    @Test
    void findById_WithNonExistentId_ShouldReturnNull() {
        // Given
        Long nonExistentId = 999L;
        when(eleveRepository.findById(nonExistentId)).thenReturn(null);

        // When
        Eleve result = eleveService.findById(nonExistentId);

        // Then
        assertThat(result).isNull();
        verify(eleveRepository).findById(nonExistentId);
    }
}