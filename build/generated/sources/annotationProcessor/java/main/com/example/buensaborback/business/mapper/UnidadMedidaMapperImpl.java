package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import com.example.buensaborback.domain.dto.UnidadMedida.UnidadMedidaDto;
import com.example.buensaborback.domain.entities.UnidadMedida;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T01:06:37-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UnidadMedidaMapperImpl implements UnidadMedidaMapper {

    @Override
    public UnidadMedidaDto toDTO(UnidadMedida source) {
        if ( source == null ) {
            return null;
        }

        UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();

        unidadMedidaDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            unidadMedidaDto.setEliminado( source.isEliminado() );
        }
        unidadMedidaDto.setDenominacion( source.getDenominacion() );

        return unidadMedidaDto;
    }

    @Override
    public UnidadMedida toEntity(UnidadMedidaDto source) {
        if ( source == null ) {
            return null;
        }

        UnidadMedida.UnidadMedidaBuilder<?, ?> unidadMedida = UnidadMedida.builder();

        unidadMedida.id( source.getId() );
        unidadMedida.eliminado( source.isEliminado() );
        unidadMedida.denominacion( source.getDenominacion() );

        return unidadMedida.build();
    }

    @Override
    public UnidadMedida toEntityCreate(UnidadMedidaCreateDto source) {
        if ( source == null ) {
            return null;
        }

        UnidadMedida.UnidadMedidaBuilder<?, ?> unidadMedida = UnidadMedida.builder();

        unidadMedida.id( source.getId() );
        unidadMedida.eliminado( source.isEliminado() );
        unidadMedida.denominacion( source.getDenominacion() );

        return unidadMedida.build();
    }

    @Override
    public UnidadMedida toUpdate(UnidadMedida entity, UnidadMedidaCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setDenominacion( source.getDenominacion() );

        return entity;
    }

    @Override
    public List<UnidadMedidaDto> toDTOsList(List<UnidadMedida> source) {
        if ( source == null ) {
            return null;
        }

        List<UnidadMedidaDto> list = new ArrayList<UnidadMedidaDto>( source.size() );
        for ( UnidadMedida unidadMedida : source ) {
            list.add( toDTO( unidadMedida ) );
        }

        return list;
    }
}
