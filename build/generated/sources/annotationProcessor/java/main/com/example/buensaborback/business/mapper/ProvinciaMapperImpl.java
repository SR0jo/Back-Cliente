package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.services.PaisService;
import com.example.buensaborback.domain.dto.Pais.PaisDto;
import com.example.buensaborback.domain.dto.Provincia.ProvinciaCreateDto;
import com.example.buensaborback.domain.dto.Provincia.ProvinciaDto;
import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.domain.entities.Provincia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T20:34:24-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ProvinciaMapperImpl implements ProvinciaMapper {

    @Autowired
    private PaisService paisService;

    @Override
    public ProvinciaDto toDTO(Provincia source) {
        if ( source == null ) {
            return null;
        }

        ProvinciaDto provinciaDto = new ProvinciaDto();

        provinciaDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            provinciaDto.setEliminado( source.isEliminado() );
        }
        provinciaDto.setNombre( source.getNombre() );
        provinciaDto.setPais( paisToPaisDto( source.getPais() ) );

        return provinciaDto;
    }

    @Override
    public Provincia toEntity(ProvinciaDto source) {
        if ( source == null ) {
            return null;
        }

        Provincia.ProvinciaBuilder<?, ?> provincia = Provincia.builder();

        provincia.id( source.getId() );
        provincia.eliminado( source.isEliminado() );
        provincia.nombre( source.getNombre() );
        provincia.pais( paisDtoToPais( source.getPais() ) );

        return provincia.build();
    }

    @Override
    public Provincia toUpdate(Provincia entity, ProvinciaCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setNombre( source.getNombre() );

        return entity;
    }

    @Override
    public List<ProvinciaDto> toDTOsList(List<Provincia> source) {
        if ( source == null ) {
            return null;
        }

        List<ProvinciaDto> list = new ArrayList<ProvinciaDto>( source.size() );
        for ( Provincia provincia : source ) {
            list.add( toDTO( provincia ) );
        }

        return list;
    }

    @Override
    public Provincia toEntityCreate(ProvinciaCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Provincia.ProvinciaBuilder<?, ?> provincia = Provincia.builder();

        provincia.pais( paisService.getById( source.getIdPais() ) );
        provincia.nombre( source.getNombre() );

        return provincia.build();
    }

    protected PaisDto paisToPaisDto(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        PaisDto paisDto = new PaisDto();

        if ( pais.isEliminado() != null ) {
            paisDto.setEliminado( pais.isEliminado() );
        }
        paisDto.setId( pais.getId() );
        paisDto.setNombre( pais.getNombre() );

        return paisDto;
    }

    protected Pais paisDtoToPais(PaisDto paisDto) {
        if ( paisDto == null ) {
            return null;
        }

        Pais.PaisBuilder<?, ?> pais = Pais.builder();

        pais.id( paisDto.getId() );
        pais.eliminado( paisDto.isEliminado() );
        pais.nombre( paisDto.getNombre() );

        return pais.build();
    }
}
