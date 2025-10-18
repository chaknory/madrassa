package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EvaluationDtoMapper {
    EvaluationDtoMapper INSTANCE = Mappers.getMapper(EvaluationDtoMapper.class);
    
    EvaluationDTO toDto(Evaluation evaluation);
    Evaluation toDomain(EvaluationDTO evaluationDTO);
}