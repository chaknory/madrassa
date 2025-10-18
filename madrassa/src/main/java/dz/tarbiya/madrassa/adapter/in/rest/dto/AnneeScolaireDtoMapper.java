package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnneeScolaireDtoMapper {
    AnneeScolaireDtoMapper INSTANCE = Mappers.getMapper(AnneeScolaireDtoMapper.class);
    
    AnneeScolaireDTO toDto(AnneeScolaire anneeScolaire);
    AnneeScolaire toDomain(AnneeScolaireDTO anneeScolaireDTO);
}