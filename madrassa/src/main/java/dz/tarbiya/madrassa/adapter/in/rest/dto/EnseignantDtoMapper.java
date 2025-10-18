package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Enseignant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnseignantDtoMapper {
    EnseignantDtoMapper INSTANCE = Mappers.getMapper(EnseignantDtoMapper.class);
    
    EnseignantDTO toDto(Enseignant enseignant);
    Enseignant toDomain(EnseignantDTO enseignantDTO);
}