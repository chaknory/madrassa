package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonneDtoMapper {
    PersonneDtoMapper INSTANCE = Mappers.getMapper(PersonneDtoMapper.class);
    PersonneDTO toDto(Personne personne);
    Personne toDomain(PersonneDTO dto);
}
