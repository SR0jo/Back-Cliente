package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.UsuarioCliente.UsuarioClienteCreateDto;
import com.example.buensaborback.domain.dto.UsuarioCliente.UsuarioClienteDto;
import com.example.buensaborback.domain.entities.UsuarioCliente;
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
public class UsuarioClienteMapperImpl implements UsuarioClienteMapper {

    @Override
    public UsuarioClienteDto toDTO(UsuarioCliente source) {
        if ( source == null ) {
            return null;
        }

        UsuarioClienteDto usuarioClienteDto = new UsuarioClienteDto();

        usuarioClienteDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            usuarioClienteDto.setEliminado( source.isEliminado() );
        }
        usuarioClienteDto.setUserName( source.getUserName() );
        usuarioClienteDto.setAuth0Id( source.getAuth0Id() );
        usuarioClienteDto.setClave( source.getClave() );

        return usuarioClienteDto;
    }

    @Override
    public UsuarioCliente toEntity(UsuarioClienteDto source) {
        if ( source == null ) {
            return null;
        }

        UsuarioCliente.UsuarioClienteBuilder usuarioCliente = UsuarioCliente.builder();

        usuarioCliente.auth0Id( source.getAuth0Id() );
        usuarioCliente.userName( source.getUserName() );
        usuarioCliente.clave( source.getClave() );

        return usuarioCliente.build();
    }

    @Override
    public UsuarioCliente toEntityCreate(UsuarioClienteCreateDto source) {
        if ( source == null ) {
            return null;
        }

        UsuarioCliente.UsuarioClienteBuilder usuarioCliente = UsuarioCliente.builder();

        usuarioCliente.auth0Id( source.getAuth0Id() );
        usuarioCliente.userName( source.getUserName() );
        usuarioCliente.clave( source.getClave() );

        return usuarioCliente.build();
    }

    @Override
    public UsuarioCliente toUpdate(UsuarioCliente entity, UsuarioClienteCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setAuth0Id( source.getAuth0Id() );
        entity.setUserName( source.getUserName() );
        entity.setClave( source.getClave() );

        return entity;
    }

    @Override
    public List<UsuarioClienteDto> toDTOsList(List<UsuarioCliente> source) {
        if ( source == null ) {
            return null;
        }

        List<UsuarioClienteDto> list = new ArrayList<UsuarioClienteDto>( source.size() );
        for ( UsuarioCliente usuarioCliente : source ) {
            list.add( toDTO( usuarioCliente ) );
        }

        return list;
    }
}
