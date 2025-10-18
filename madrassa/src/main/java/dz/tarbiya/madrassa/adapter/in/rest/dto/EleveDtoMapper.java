package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Eleve;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EleveDtoMapper {
    EleveDtoMapper INSTANCE = Mappers.getMapper(EleveDtoMapper.class);
    
    EleveDTO toDto(Eleve eleve);
    Eleve toDomain(EleveDTO eleveDTO);
}