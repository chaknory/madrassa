package dz.tarbiya.madrassa.adapter.out.jpa;

import dz.tarbiya.madrassa.domain.model.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonneMapper {
    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);
    PersonneEntity toEntity(Personne personne);
    Personne toDomain(PersonneEntity entity);
}
