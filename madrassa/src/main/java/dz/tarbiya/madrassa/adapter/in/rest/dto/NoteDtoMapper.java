package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteDtoMapper {
    NoteDtoMapper INSTANCE = Mappers.getMapper(NoteDtoMapper.class);
    
    NoteDTO toDto(Note note);
    Note toDomain(NoteDTO noteDTO);
}