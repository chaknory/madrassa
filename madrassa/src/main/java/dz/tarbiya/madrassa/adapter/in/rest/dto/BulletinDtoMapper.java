package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Bulletin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BulletinDtoMapper {
    BulletinDtoMapper INSTANCE = Mappers.getMapper(BulletinDtoMapper.class);
    
    BulletinDTO toDto(Bulletin bulletin);
    Bulletin toDomain(BulletinDTO bulletinDTO);
}