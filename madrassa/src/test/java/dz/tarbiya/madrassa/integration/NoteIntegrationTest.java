package dz.tarbiya.madrassa.integration;

import dz.tarbiya.madrassa.domain.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class NoteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void completeNoteWorkflow_ShouldWork() throws Exception {
        // Créer une note
        Note noteToCreate = new Note(
                null,
                1L,
                1L,
                16.5,
                false,
                false,
                "Note d'intégration",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        String noteJson = mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteToCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valeur").value(16.5))
                .andExpect(jsonPath("$.appreciation").value("Note d'intégration"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Note createdNote = objectMapper.readValue(noteJson, Note.class);
        Long noteId = createdNote.idNote();

        // Récupérer la note créée
        mockMvc.perform(get("/api/notes/{id}", noteId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idNote").value(noteId))
                .andExpect(jsonPath("$.valeur").value(16.5));

        // Lister toutes les notes
        mockMvc.perform(get("/api/notes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        // Supprimer la note
        mockMvc.perform(delete("/api/notes/{id}", noteId))
                .andExpect(status().isNoContent());

        // Vérifier que la note n'existe plus
        mockMvc.perform(get("/api/notes/{id}", noteId))
                .andExpect(status().isNotFound());
    }
}