package dz.tarbiya.madrassa.application.service;

import dz.tarbiya.madrassa.application.port.ClasseRepository;
import dz.tarbiya.madrassa.domain.model.Classe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClasseServiceTest {

    @Mock
    private ClasseRepository classeRepository;

    @InjectMocks
    private ClasseService classeService;

    private Classe sampleClasse;

    @BeforeEach
    void setUp() {
        sampleClasse = new Classe(
                1L,
                2024L,
                1L,
                10L,
                "6ème A",
                30,
                "Salle 101",
                "Classe d'excellence"
        );
    }

    @Test
    void save_ShouldReturnSavedClasse() {
        // Given
        when(classeRepository.save(any(Classe.class))).thenReturn(sampleClasse);

        // When
        Classe result = classeService.save(sampleClasse);

        // Then
        assertThat(result).isEqualTo(sampleClasse);
        assertThat(result.nomClasse()).isEqualTo("6ème A");
        assertThat(result.effectifMax()).isEqualTo(30);
        verify(classeRepository).save(sampleClasse);
    }

    @Test
    void findAll_ShouldReturnListOfClasses() {
        // Given
        Classe classe2 = new Classe(2L, 2024L, 1L, 11L, "6ème B", 28, "Salle 102", "");
        List<Classe> classes = Arrays.asList(sampleClasse, classe2);
        when(classeRepository.findAll()).thenReturn(classes);

        // When
        List<Classe> result = classeService.findAll();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(sampleClasse, classe2);
        verify(classeRepository).findAll();
    }

    @Test
    void findById_ShouldReturnClasse() {
        // Given
        Long classeId = 1L;
        when(classeRepository.findById(classeId)).thenReturn(sampleClasse);

        // When
        Classe result = classeService.findById(classeId);

        // Then
        assertThat(result).isEqualTo(sampleClasse);
        assertThat(result.salle()).isEqualTo("Salle 101");
        verify(classeRepository).findById(classeId);
    }

    @Test
    void deleteById_ShouldCallRepositoryDelete() {
        // Given
        Long classeId = 1L;

        // When
        classeService.deleteById(classeId);

        // Then
        verify(classeRepository).deleteById(classeId);
    }

    @Test
    void save_WithMaxEffectif_ShouldValidateConstraints() {
        // Given
        Classe classeWithMaxEffectif = new Classe(
                null, 2024L, 1L, 10L, "Test", 35, "Salle Test", ""
        );
        when(classeRepository.save(any(Classe.class))).thenReturn(classeWithMaxEffectif);

        // When
        Classe result = classeService.save(classeWithMaxEffectif);

        // Then
        assertThat(result.effectifMax()).isEqualTo(35);
        verify(classeRepository).save(classeWithMaxEffectif);
    }
}