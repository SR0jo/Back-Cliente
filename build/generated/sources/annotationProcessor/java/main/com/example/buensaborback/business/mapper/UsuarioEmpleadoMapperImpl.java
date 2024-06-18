package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.UsuarioEmpleado.UsuarioEmpleadoCreateDto;
import com.example.buensaborback.domain.dto.UsuarioEmpleado.UsuarioEmpleadoDto;
import com.example.buensaborback.domain.entities.UsuarioEmpleado;
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
public class UsuarioEmpleadoMapperImpl implements UsuarioEmpleadoMapper {

    @Override
    public UsuarioEmpleadoDto toDTO(UsuarioEmpleado source) {
        if ( source == null ) {
            return null;
        }

        UsuarioEmpleadoDto usuarioEmpleadoDto = new UsuarioEmpleadoDto();

        usuarioEmpleadoDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            usuarioEmpleadoDto.setEliminado( source.isEliminado() );
        }
        usuarioEmpleadoDto.setAuth0Id( source.getAuth0Id() );
        usuarioEmpleadoDto.setUserName( source.getUserName() );

        return usuarioEmpleadoDto;
    }

    @Override
    public UsuarioEmpleado toEntity(UsuarioEmpleadoDto source) {
        if ( source == null ) {
            return null;
        }

        UsuarioEmpleado.UsuarioEmpleadoBuilder usuarioEmpleado = UsuarioEmpleado.builder();

        usuarioEmpleado.auth0Id( source.getAuth0Id() );
        usuarioEmpleado.userName( source.getUserName() );

        return usuarioEmpleado.build();
    }

    @Override
    public UsuarioEmpleado toEntityCreate(UsuarioEmpleadoCreateDto source) {
        if ( source == null ) {
            return null;
        }

        UsuarioEmpleado.UsuarioEmpleadoBuilder usuarioEmpleado = UsuarioEmpleado.builder();

        usuarioEmpleado.auth0Id( source.getAuth0Id() );
        usuarioEmpleado.userName( source.getUserName() );

        return usuarioEmpleado.build();
    }

    @Override
    public UsuarioEmpleado toUpdate(UsuarioEmpleado entity, UsuarioEmpleadoCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setAuth0Id( source.getAuth0Id() );
        entity.setUserName( source.getUserName() );

        return entity;
    }

    @Override
    public List<UsuarioEmpleadoDto> toDTOsList(List<UsuarioEmpleado> source) {
        if ( source == null ) {
            return null;
        }

        List<UsuarioEmpleadoDto> list = new ArrayList<UsuarioEmpleadoDto>( source.size() );
        for ( UsuarioEmpleado usuarioEmpleado : source ) {
            list.add( toDTO( usuarioEmpleado ) );
        }

        return list;
    }
}
