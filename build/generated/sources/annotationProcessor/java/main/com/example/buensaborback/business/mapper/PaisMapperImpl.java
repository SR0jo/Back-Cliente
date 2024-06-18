package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.Pais.PaisCreateDto;
import com.example.buensaborback.domain.dto.Pais.PaisDto;
import com.example.buensaborback.domain.entities.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T20:34:24-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class PaisMapperImpl implements PaisMapper {

    @Override
    public PaisDto toDTO(Pais source) {
        if ( source == null ) {
            return null;
        }

        PaisDto paisDto = new PaisDto();

        if ( source.isEliminado() != null ) {
            paisDto.setEliminado( source.isEliminado() );
        }
        paisDto.setId( source.getId() );
        paisDto.setNombre( source.getNombre() );

        return paisDto;
    }

    @Override
    public Pais toEntity(PaisDto source) {
        if ( source == null ) {
            return null;
        }

        Pais.PaisBuilder<?, ?> pais = Pais.builder();

        pais.id( source.getId() );
        pais.eliminado( source.isEliminado() );
        pais.nombre( source.getNombre() );

        return pais.build();
    }

    @Override
    public Pais toEntityCreate(PaisCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Pais.PaisBuilder<?, ?> pais = Pais.builder();

        pais.nombre( source.getNombre() );

        return pais.build();
    }

    @Override
    public Pais toUpdate(Pais entity, PaisCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setNombre( source.getNombre() );

        return entity;
    }

    @Override
    public List<PaisDto> toDTOsList(List<Pais> source) {
        if ( source == null ) {
            return null;
        }

        List<PaisDto> list = new ArrayList<PaisDto>( source.size() );
        for ( Pais pais : source ) {
            list.add( toDTO( pais ) );
        }

        return list;
    }
}
