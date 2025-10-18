package dz.tarbiya.madrassa.adapter.out.jpa.personnel;

import dz.tarbiya.madrassa.domain.model.Personnel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonnelRepositoryAdapterTest {

    @Mock
    private PersonnelJpaRepository jpaRepository;

    @InjectMocks
    private PersonnelRepositoryAdapter repositoryAdapter;

    private Personnel samplePersonnel;
    private PersonnelEntity sampleEntity;

    @BeforeEach
    void setUp() {
        samplePersonnel = new Personnel(
                1L,
                10L,
                "EMP001",
                "Directeur",
                LocalDate.of(2020, 1, 15),
                "Administration",
                true
        );

        sampleEntity = new PersonnelEntity();
        sampleEntity.setIdPersonnel(1L);
        sampleEntity.setIdPersonne(10L);
        sampleEntity.setNumeroEmploye("EMP001");
        sampleEntity.setFonction("Directeur");
        sampleEntity.setDateEmbauche(LocalDate.of(2020, 1, 15));
        sampleEntity.setService("Administration");
        sampleEntity.setActif(true);
    }

    @Test
    void save_ShouldConvertAndSavePersonnel() {
        // Given
        when(jpaRepository.save(any(PersonnelEntity.class))).thenReturn(sampleEntity);

        // When
        Personnel result = repositoryAdapter.save(samplePersonnel);

        // Then
        assertThat(result.idPersonnel()).isEqualTo(1L);
        assertThat(result.numeroEmploye()).isEqualTo("EMP001");
        assertThat(result.fonction()).isEqualTo("Directeur");
        assertThat(result.service()).isEqualTo("Administration");
        assertThat(result.actif()).isTrue();
        verify(jpaRepository).save(any(PersonnelEntity.class));
    }

    @Test
    void findAll_ShouldReturnConvertedPersonnels() {
        // Given
        PersonnelEntity entity2 = new PersonnelEntity();
        entity2.setIdPersonnel(2L);
        entity2.setNumeroEmploye("EMP002");
        entity2.setFonction("Secrétaire");
        
        List<PersonnelEntity> entities = Arrays.asList(sampleEntity, entity2);
        when(jpaRepository.findAll()).thenReturn(entities);

        // When
        List<Personnel> result = repositoryAdapter.findAll();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).numeroEmploye()).isEqualTo("EMP001");
        assertThat(result.get(1).numeroEmploye()).isEqualTo("EMP002");
        verify(jpaRepository).findAll();
    }

    @Test
    void findById_WhenFound_ShouldReturnConvertedPersonnel() {
        // Given
        Long personnelId = 1L;
        when(jpaRepository.findById(personnelId)).thenReturn(Optional.of(sampleEntity));

        // When
        Personnel result = repositoryAdapter.findById(personnelId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.idPersonnel()).isEqualTo(1L);
        assertThat(result.fonction()).isEqualTo("Directeur");
        assertThat(result.dateEmbauche()).isEqualTo(LocalDate.of(2020, 1, 15));
        verify(jpaRepository).findById(personnelId);
    }

    @Test
    void findById_WhenNotFound_ShouldReturnNull() {
        // Given
        Long personnelId = 999L;
        when(jpaRepository.findById(personnelId)).thenReturn(Optional.empty());

        // When
        Personnel result = repositoryAdapter.findById(personnelId);

        // Then
        assertThat(result).isNull();
        verify(jpaRepository).findById(personnelId);
    }

    @Test
    void deleteById_ShouldCallJpaRepositoryDelete() {
        // Given
        Long personnelId = 1L;

        // When
        repositoryAdapter.deleteById(personnelId);

        // Then
        verify(jpaRepository).deleteById(personnelId);
    }
}