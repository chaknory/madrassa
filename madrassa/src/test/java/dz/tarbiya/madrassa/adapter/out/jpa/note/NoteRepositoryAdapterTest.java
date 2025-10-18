package dz.tarbiya.madrassa.adapter.out.jpa.note;

import dz.tarbiya.madrassa.domain.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteRepositoryAdapterTest {

    @Mock
    private NoteJpaRepository jpaRepository;

    @InjectMocks
    private NoteRepositoryAdapter repositoryAdapter;

    private Note sampleNote;
    private NoteEntity sampleEntity;

    @BeforeEach
    void setUp() {
        sampleNote = new Note(
                1L,
                101L,
                201L,
                15.5,
                false,
                false,
                "Bonne note",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        sampleEntity = new NoteEntity();
        sampleEntity.setIdNote(1L);
        sampleEntity.setIdEvaluation(101L);
        sampleEntity.setIdEleve(201L);
        sampleEntity.setValeur(15.5);
        sampleEntity.setAbsent(false);
        sampleEntity.setDispense(false);
        sampleEntity.setAppreciation("Bonne note");
        sampleEntity.setDateSaisie(sampleNote.dateSaisie());
        sampleEntity.setDateModification(sampleNote.dateModification());
    }

    @Test
    void save_ShouldConvertAndSaveNote() {
        // Given
        when(jpaRepository.save(any(NoteEntity.class))).thenReturn(sampleEntity);

        // When
        Note result = repositoryAdapter.save(sampleNote);

        // Then
        assertThat(result.idNote()).isEqualTo(1L);
        assertThat(result.valeur()).isEqualTo(15.5);
        assertThat(result.appreciation()).isEqualTo("Bonne note");
        verify(jpaRepository).save(any(NoteEntity.class));
    }

    @Test
    void findAll_ShouldReturnConvertedNotes() {
        // Given
        List<NoteEntity> entities = Arrays.asList(sampleEntity);
        when(jpaRepository.findAll()).thenReturn(entities);

        // When
        List<Note> result = repositoryAdapter.findAll();

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).idNote()).isEqualTo(1L);
        assertThat(result.get(0).valeur()).isEqualTo(15.5);
        verify(jpaRepository).findAll();
    }

    @Test
    void findById_WhenFound_ShouldReturnConvertedNote() {
        // Given
        Long noteId = 1L;
        when(jpaRepository.findById(noteId)).thenReturn(Optional.of(sampleEntity));

        // When
        Note result = repositoryAdapter.findById(noteId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.idNote()).isEqualTo(1L);
        assertThat(result.appreciation()).isEqualTo("Bonne note");
        verify(jpaRepository).findById(noteId);
    }

    @Test
    void findById_WhenNotFound_ShouldReturnNull() {
        // Given
        Long noteId = 999L;
        when(jpaRepository.findById(noteId)).thenReturn(Optional.empty());

        // When
        Note result = repositoryAdapter.findById(noteId);

        // Then
        assertThat(result).isNull();
        verify(jpaRepository).findById(noteId);
    }

    @Test
    void deleteById_ShouldCallJpaRepositoryDelete() {
        // Given
        Long noteId = 1L;

        // When
        repositoryAdapter.deleteById(noteId);

        // Then
        verify(jpaRepository).deleteById(noteId);
    }
}