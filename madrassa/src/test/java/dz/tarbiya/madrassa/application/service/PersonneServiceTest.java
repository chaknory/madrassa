package dz.tarbiya.madrassa.application.service;

import dz.tarbiya.madrassa.application.port.PersonneRepository;
import dz.tarbiya.madrassa.domain.model.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonneServiceTest {

    @Mock
    private PersonneRepository personneRepository;

    @InjectMocks
    private PersonneService personneService;

    private Personne samplePersonne;

    @BeforeEach
    void setUp() {
        samplePersonne = new Personne(
                1L,
                "Doe",
                "John",
                LocalDate.of(1990, 1, 1),
                "M",
                "john.doe@email.com",
                "0123456789",
                "0987654321",
                "123 Rue Test",
                "75001",
                "Paris",
                "France",
                "photo.jpg",
                "ENSEIGNANT",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Test
    void save_ShouldReturnSavedPersonne() {
        // Given
        when(personneRepository.save(any(Personne.class))).thenReturn(samplePersonne);

        // When
        Personne result = personneService.save(samplePersonne);

        // Then
        assertThat(result).isEqualTo(samplePersonne);
        assertThat(result.nom()).isEqualTo("Doe");
        assertThat(result.prenom()).isEqualTo("John");
        verify(personneRepository).save(samplePersonne);
    }

    @Test
    void findAll_ShouldReturnListOfPersonnes() {
        // Given
        List<Personne> personnes = Arrays.asList(samplePersonne);
        when(personneRepository.findAll()).thenReturn(personnes);

        // When
        List<Personne> result = personneService.findAll();

        // Then
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(samplePersonne);
        verify(personneRepository).findAll();
    }

    @Test
    void findById_ShouldReturnPersonne() {
        // Given
        Long personneId = 1L;
        when(personneRepository.findById(personneId)).thenReturn(samplePersonne);

        // When
        Personne result = personneService.findById(personneId);

        // Then
        assertThat(result).isEqualTo(samplePersonne);
        assertThat(result.email()).isEqualTo("john.doe@email.com");
        verify(personneRepository).findById(personneId);
    }

    @Test
    void deleteById_ShouldCallRepositoryDelete() {
        // Given
        Long personneId = 1L;

        // When
        personneService.deleteById(personneId);

        // Then
        verify(personneRepository).deleteById(personneId);
    }
}