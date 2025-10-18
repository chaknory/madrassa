package dz.tarbiya.madrassa.adapter.in.rest;

import dz.tarbiya.madrassa.application.service.NoteService;
import dz.tarbiya.madrassa.domain.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Autowired
    private ObjectMapper objectMapper;

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
    void getAll_ShouldReturnListOfNotes() throws Exception {
        // Given
        List<Note> notes = Arrays.asList(sampleNote);
        when(noteService.findAll()).thenReturn(notes);

        // When & Then
        mockMvc.perform(get("/api/notes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].idNote").value(1))
                .andExpect(jsonPath("$[0].valeur").value(15.5))
                .andExpect(jsonPath("$[0].appreciation").value("Bonne note"));
    }

    @Test
    void getById_WhenFound_ShouldReturnNote() throws Exception {
        // Given
        Long noteId = 1L;
        when(noteService.findById(noteId)).thenReturn(sampleNote);

        // When & Then
        mockMvc.perform(get("/api/notes/{id}", noteId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idNote").value(1))
                .andExpect(jsonPath("$.valeur").value(15.5))
                .andExpect(jsonPath("$.appreciation").value("Bonne note"));
    }

    @Test
    void getById_WhenNotFound_ShouldReturnNotFound() throws Exception {
        // Given
        Long noteId = 999L;
        when(noteService.findById(noteId)).thenReturn(null);

        // When & Then
        mockMvc.perform(get("/api/notes/{id}", noteId))
                .andExpect(status().isNotFound());
    }

    @Test
    void create_ShouldReturnCreatedNote() throws Exception {
        // Given
        Note noteToCreate = new Note(
                null,
                101L,
                201L,
                18.0,
                false,
                false,
                "Excellente note",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        
        Note createdNote = new Note(
                2L,
                101L,
                201L,
                18.0,
                false,
                false,
                "Excellente note",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        
        when(noteService.save(any(Note.class))).thenReturn(createdNote);

        // When & Then
        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteToCreate)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idNote").value(2))
                .andExpect(jsonPath("$.valeur").value(18.0))
                .andExpect(jsonPath("$.appreciation").value("Excellente note"));
    }

    @Test
    void delete_ShouldReturnNoContent() throws Exception {
        // Given
        Long noteId = 1L;

        // When & Then
        mockMvc.perform(delete("/api/notes/{id}", noteId))
                .andExpect(status().isNoContent());
    }
}