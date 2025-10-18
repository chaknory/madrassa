package dz.tarbiya.madrassa.application.service;

import dz.tarbiya.madrassa.application.port.NoteRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    private Note sampleNote;

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
    }

    @Test
    void save_ShouldReturnSavedNote() {
        // Given
        when(noteRepository.save(any(Note.class))).thenReturn(sampleNote);

        // When
        Note result = noteService.save(sampleNote);

        // Then
        assertThat(result).isEqualTo(sampleNote);
        verify(noteRepository).save(sampleNote);
    }

    @Test
    void findAll_ShouldReturnListOfNotes() {
        // Given
        List<Note> notes = Arrays.asList(sampleNote, sampleNote);
        when(noteRepository.findAll()).thenReturn(notes);

        // When
        List<Note> result = noteService.findAll();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(sampleNote, sampleNote);
        verify(noteRepository).findAll();
    }

    @Test
    void findById_ShouldReturnNote() {
        // Given
        Long noteId = 1L;
        when(noteRepository.findById(noteId)).thenReturn(sampleNote);

        // When
        Note result = noteService.findById(noteId);

        // Then
        assertThat(result).isEqualTo(sampleNote);
        verify(noteRepository).findById(noteId);
    }

    @Test
    void deleteById_ShouldCallRepositoryDelete() {
        // Given
        Long noteId = 1L;

        // When
        noteService.deleteById(noteId);

        // Then
        verify(noteRepository).deleteById(noteId);
    }
}