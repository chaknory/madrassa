package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InscriptionDtoMapper {
    InscriptionDtoMapper INSTANCE = Mappers.getMapper(InscriptionDtoMapper.class);
    
    InscriptionDTO toDto(Inscription inscription);
    Inscription toDomain(InscriptionDTO inscriptionDTO);
}