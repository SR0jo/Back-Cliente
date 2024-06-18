package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.services.EmpresaService;
import com.example.buensaborback.domain.dto.Empresa.EmpresaDto;
import com.example.buensaborback.domain.dto.ImagenEmpresa.ImagenEmpresaDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalCreateDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalEditDto;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.ImagenEmpresa;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Sucursal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T23:02:30-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class SucursalMapperImpl implements SucursalMapper {

    @Autowired
    private DomicilioMapper domicilioMapper;
    @Autowired
    private EmpresaService empresaService;

    @Override
    public SucursalDto toDTO(Sucursal source) {
        if ( source == null ) {
            return null;
        }

        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            sucursalDto.setEliminado( source.isEliminado() );
        }
        sucursalDto.setNombre( source.getNombre() );
        sucursalDto.setHorarioApertura( source.getHorarioApertura() );
        sucursalDto.setHorarioCierre( source.getHorarioCierre() );
        sucursalDto.setEsCasaMatriz( source.getEsCasaMatriz() );
        sucursalDto.setDomicilio( domicilioMapper.toDTO( source.getDomicilio() ) );
        sucursalDto.setEmpresa( empresaToEmpresaDto( source.getEmpresa() ) );
        sucursalDto.setImagenes( imagenSucursalSetToImagenSucursalDtoList( source.getImagenes() ) );

        return sucursalDto;
    }

    @Override
    public Sucursal toEntity(SucursalDto source) {
        if ( source == null ) {
            return null;
        }

        Sucursal.SucursalBuilder<?, ?> sucursal = Sucursal.builder();

        sucursal.id( source.getId() );
        sucursal.eliminado( source.isEliminado() );
        sucursal.nombre( source.getNombre() );
        sucursal.horarioApertura( source.getHorarioApertura() );
        sucursal.horarioCierre( source.getHorarioCierre() );
        sucursal.esCasaMatriz( source.getEsCasaMatriz() );
        sucursal.domicilio( domicilioMapper.toEntity( source.getDomicilio() ) );
        sucursal.empresa( empresaDtoToEmpresa( source.getEmpresa() ) );
        sucursal.imagenes( imagenSucursalDtoListToImagenSucursalSet( source.getImagenes() ) );

        return sucursal.build();
    }

    @Override
    public Sucursal toUpdate(Sucursal entity, SucursalEditDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setNombre( source.getNombre() );
        entity.setHorarioApertura( source.getHorarioApertura() );
        entity.setHorarioCierre( source.getHorarioCierre() );
        entity.setEsCasaMatriz( source.getEsCasaMatriz() );

        return entity;
    }

    @Override
    public List<SucursalDto> toDTOsList(List<Sucursal> source) {
        if ( source == null ) {
            return null;
        }

        List<SucursalDto> list = new ArrayList<SucursalDto>( source.size() );
        for ( Sucursal sucursal : source ) {
            list.add( toDTO( sucursal ) );
        }

        return list;
    }

    @Override
    public Sucursal toEntityCreate(SucursalCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Sucursal.SucursalBuilder<?, ?> sucursal = Sucursal.builder();

        sucursal.empresa( empresaService.getById( source.getIdEmpresa() ) );
        sucursal.id( source.getId() );
        sucursal.eliminado( source.isEliminado() );
        sucursal.nombre( source.getNombre() );
        sucursal.horarioApertura( source.getHorarioApertura() );
        sucursal.horarioCierre( source.getHorarioCierre() );
        sucursal.esCasaMatriz( source.getEsCasaMatriz() );
        sucursal.domicilio( domicilioMapper.toEntityCreate( source.getDomicilio() ) );

        return sucursal.build();
    }

    protected ImagenEmpresaDto imagenEmpresaToImagenEmpresaDto(ImagenEmpresa imagenEmpresa) {
        if ( imagenEmpresa == null ) {
            return null;
        }

        ImagenEmpresaDto imagenEmpresaDto = new ImagenEmpresaDto();

        imagenEmpresaDto.setName( imagenEmpresa.getName() );
        imagenEmpresaDto.setUrl( imagenEmpresa.getUrl() );

        return imagenEmpresaDto;
    }

    protected List<ImagenEmpresaDto> imagenEmpresaSetToImagenEmpresaDtoList(Set<ImagenEmpresa> set) {
        if ( set == null ) {
            return null;
        }

        List<ImagenEmpresaDto> list = new ArrayList<ImagenEmpresaDto>( set.size() );
        for ( ImagenEmpresa imagenEmpresa : set ) {
            list.add( imagenEmpresaToImagenEmpresaDto( imagenEmpresa ) );
        }

        return list;
    }

    protected EmpresaDto empresaToEmpresaDto(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDto empresaDto = new EmpresaDto();

        empresaDto.setId( empresa.getId() );
        if ( empresa.isEliminado() != null ) {
            empresaDto.setEliminado( empresa.isEliminado() );
        }
        empresaDto.setNombre( empresa.getNombre() );
        empresaDto.setRazonSocial( empresa.getRazonSocial() );
        empresaDto.setCuil( empresa.getCuil() );
        empresaDto.setImagenes( imagenEmpresaSetToImagenEmpresaDtoList( empresa.getImagenes() ) );

        return empresaDto;
    }

    protected ImagenSucursalDto imagenSucursalToImagenSucursalDto(ImagenSucursal imagenSucursal) {
        if ( imagenSucursal == null ) {
            return null;
        }

        ImagenSucursalDto imagenSucursalDto = new ImagenSucursalDto();

        imagenSucursalDto.setName( imagenSucursal.getName() );
        imagenSucursalDto.setUrl( imagenSucursal.getUrl() );

        return imagenSucursalDto;
    }

    protected List<ImagenSucursalDto> imagenSucursalSetToImagenSucursalDtoList(Set<ImagenSucursal> set) {
        if ( set == null ) {
            return null;
        }

        List<ImagenSucursalDto> list = new ArrayList<ImagenSucursalDto>( set.size() );
        for ( ImagenSucursal imagenSucursal : set ) {
            list.add( imagenSucursalToImagenSucursalDto( imagenSucursal ) );
        }

        return list;
    }

    protected ImagenEmpresa imagenEmpresaDtoToImagenEmpresa(ImagenEmpresaDto imagenEmpresaDto) {
        if ( imagenEmpresaDto == null ) {
            return null;
        }

        ImagenEmpresa.ImagenEmpresaBuilder<?, ?> imagenEmpresa = ImagenEmpresa.builder();

        imagenEmpresa.name( imagenEmpresaDto.getName() );
        imagenEmpresa.url( imagenEmpresaDto.getUrl() );

        return imagenEmpresa.build();
    }

    protected Set<ImagenEmpresa> imagenEmpresaDtoListToImagenEmpresaSet(List<ImagenEmpresaDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<ImagenEmpresa> set = new LinkedHashSet<ImagenEmpresa>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ImagenEmpresaDto imagenEmpresaDto : list ) {
            set.add( imagenEmpresaDtoToImagenEmpresa( imagenEmpresaDto ) );
        }

        return set;
    }

    protected Empresa empresaDtoToEmpresa(EmpresaDto empresaDto) {
        if ( empresaDto == null ) {
            return null;
        }

        Empresa.EmpresaBuilder<?, ?> empresa = Empresa.builder();

        empresa.id( empresaDto.getId() );
        empresa.eliminado( empresaDto.isEliminado() );
        empresa.nombre( empresaDto.getNombre() );
        empresa.razonSocial( empresaDto.getRazonSocial() );
        empresa.cuil( empresaDto.getCuil() );
        empresa.imagenes( imagenEmpresaDtoListToImagenEmpresaSet( empresaDto.getImagenes() ) );

        return empresa.build();
    }

    protected ImagenSucursal imagenSucursalDtoToImagenSucursal(ImagenSucursalDto imagenSucursalDto) {
        if ( imagenSucursalDto == null ) {
            return null;
        }

        ImagenSucursal.ImagenSucursalBuilder<?, ?> imagenSucursal = ImagenSucursal.builder();

        imagenSucursal.name( imagenSucursalDto.getName() );
        imagenSucursal.url( imagenSucursalDto.getUrl() );

        return imagenSucursal.build();
    }

    protected Set<ImagenSucursal> imagenSucursalDtoListToImagenSucursalSet(List<ImagenSucursalDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<ImagenSucursal> set = new LinkedHashSet<ImagenSucursal>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ImagenSucursalDto imagenSucursalDto : list ) {
            set.add( imagenSucursalDtoToImagenSucursal( imagenSucursalDto ) );
        }

        return set;
    }
}
