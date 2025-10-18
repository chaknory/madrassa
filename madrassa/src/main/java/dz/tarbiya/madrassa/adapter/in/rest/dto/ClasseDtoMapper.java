package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Classe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClasseDtoMapper {
    ClasseDtoMapper INSTANCE = Mappers.getMapper(ClasseDtoMapper.class);
    
    ClasseDTO toDto(Classe classe);
    Classe toDomain(ClasseDTO classeDTO);
}