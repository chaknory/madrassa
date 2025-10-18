package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Absence;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AbsenceDtoMapper {
    AbsenceDtoMapper INSTANCE = Mappers.getMapper(AbsenceDtoMapper.class);
    
    AbsenceDTO toDto(Absence absence);
    Absence toDomain(AbsenceDTO absenceDTO);
}