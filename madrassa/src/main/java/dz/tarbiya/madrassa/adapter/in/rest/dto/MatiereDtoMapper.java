package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Matiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MatiereDtoMapper {
    MatiereDtoMapper INSTANCE = Mappers.getMapper(MatiereDtoMapper.class);
    
    MatiereDTO toDto(Matiere matiere);
    Matiere toDomain(MatiereDTO matiereDTO);
}