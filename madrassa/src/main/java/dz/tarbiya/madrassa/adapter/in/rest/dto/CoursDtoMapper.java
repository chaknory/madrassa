package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Cours;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoursDtoMapper {
    CoursDtoMapper INSTANCE = Mappers.getMapper(CoursDtoMapper.class);
    
    CoursDTO toDto(Cours cours);
    Cours toDomain(CoursDTO coursDTO);
}