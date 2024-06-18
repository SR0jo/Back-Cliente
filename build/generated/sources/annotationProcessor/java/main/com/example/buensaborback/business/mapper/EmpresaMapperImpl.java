package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.Domicilio.DomicilioDto;
import com.example.buensaborback.domain.dto.Empresa.EmpresaCreateDto;
import com.example.buensaborback.domain.dto.Empresa.EmpresaDto;
import com.example.buensaborback.domain.dto.Empresa.EmpresaLargeDto;
import com.example.buensaborback.domain.dto.ImagenEmpresa.ImagenEmpresaDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Localidad.LocalidadDto;
import com.example.buensaborback.domain.dto.Pais.PaisDto;
import com.example.buensaborback.domain.dto.Provincia.ProvinciaDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalShortDto;
import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.ImagenEmpresa;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Localidad;
import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.domain.entities.Provincia;
import com.example.buensaborback.domain.entities.Sucursal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T20:34:25-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public EmpresaDto toDTO(Empresa source) {
        if ( source == null ) {
            return null;
        }

        EmpresaDto empresaDto = new EmpresaDto();

        empresaDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            empresaDto.setEliminado( source.isEliminado() );
        }
        empresaDto.setNombre( source.getNombre() );
        empresaDto.setRazonSocial( source.getRazonSocial() );
        empresaDto.setCuil( source.getCuil() );
        empresaDto.setImagenes( imagenEmpresaSetToImagenEmpresaDtoList( source.getImagenes() ) );

        return empresaDto;
    }

    @Override
    public Empresa toEntity(EmpresaDto source) {
        if ( source == null ) {
            return null;
        }

        Empresa.EmpresaBuilder<?, ?> empresa = Empresa.builder();

        empresa.id( source.getId() );
        empresa.eliminado( source.isEliminado() );
        empresa.nombre( source.getNombre() );
        empresa.razonSocial( source.getRazonSocial() );
        empresa.cuil( source.getCuil() );
        empresa.imagenes( imagenEmpresaDtoListToImagenEmpresaSet( source.getImagenes() ) );

        return empresa.build();
    }

    @Override
    public Empresa toEntityCreate(EmpresaCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Empresa.EmpresaBuilder<?, ?> empresa = Empresa.builder();

        empresa.id( source.getId() );
        empresa.eliminado( source.isEliminado() );
        empresa.nombre( source.getNombre() );
        empresa.razonSocial( source.getRazonSocial() );
        empresa.cuil( source.getCuil() );

        return empresa.build();
    }

    @Override
    public Empresa toUpdate(Empresa entity, EmpresaCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setNombre( source.getNombre() );
        entity.setRazonSocial( source.getRazonSocial() );
        entity.setCuil( source.getCuil() );

        return entity;
    }

    @Override
    public List<EmpresaDto> toDTOsList(List<Empresa> source) {
        if ( source == null ) {
            return null;
        }

        List<EmpresaDto> list = new ArrayList<EmpresaDto>( source.size() );
        for ( Empresa empresa : source ) {
            list.add( toDTO( empresa ) );
        }

        return list;
    }

    @Override
    public EmpresaLargeDto toLargeDto(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaLargeDto empresaLargeDto = new EmpresaLargeDto();

        empresaLargeDto.setId( empresa.getId() );
        if ( empresa.isEliminado() != null ) {
            empresaLargeDto.setEliminado( empresa.isEliminado() );
        }
        empresaLargeDto.setNombre( empresa.getNombre() );
        empresaLargeDto.setRazonSocial( empresa.getRazonSocial() );
        empresaLargeDto.setCuil( empresa.getCuil() );
        empresaLargeDto.setSucursales( sucursalSetToSucursalShortDtoSet( empresa.getSucursales() ) );

        return empresaLargeDto;
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

    protected ProvinciaDto provinciaToProvinciaDto(Provincia provincia) {
        if ( provincia == null ) {
            return null;
        }

        ProvinciaDto provinciaDto = new ProvinciaDto();

        provinciaDto.setId( provincia.getId() );
        if ( provincia.isEliminado() != null ) {
            provinciaDto.setEliminado( provincia.isEliminado() );
        }
        provinciaDto.setNombre( provincia.getNombre() );
        provinciaDto.setPais( paisToPaisDto( provincia.getPais() ) );

        return provinciaDto;
    }

    protected LocalidadDto localidadToLocalidadDto(Localidad localidad) {
        if ( localidad == null ) {
            return null;
        }

        LocalidadDto localidadDto = new LocalidadDto();

        localidadDto.setId( localidad.getId() );
        if ( localidad.isEliminado() != null ) {
            localidadDto.setEliminado( localidad.isEliminado() );
        }
        localidadDto.setNombre( localidad.getNombre() );
        localidadDto.setProvincia( provinciaToProvinciaDto( localidad.getProvincia() ) );

        return localidadDto;
    }

    protected DomicilioDto domicilioToDomicilioDto(Domicilio domicilio) {
        if ( domicilio == null ) {
            return null;
        }

        DomicilioDto domicilioDto = new DomicilioDto();

        domicilioDto.setId( domicilio.getId() );
        if ( domicilio.isEliminado() != null ) {
            domicilioDto.setEliminado( domicilio.isEliminado() );
        }
        domicilioDto.setCalle( domicilio.getCalle() );
        domicilioDto.setNumero( domicilio.getNumero() );
        domicilioDto.setCp( domicilio.getCp() );
        domicilioDto.setPiso( domicilio.getPiso() );
        domicilioDto.setNroDpto( domicilio.getNroDpto() );
        domicilioDto.setLocalidad( localidadToLocalidadDto( domicilio.getLocalidad() ) );

        return domicilioDto;
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

    protected SucursalShortDto sucursalToSucursalShortDto(Sucursal sucursal) {
        if ( sucursal == null ) {
            return null;
        }

        SucursalShortDto sucursalShortDto = new SucursalShortDto();

        sucursalShortDto.setId( sucursal.getId() );
        if ( sucursal.isEliminado() != null ) {
            sucursalShortDto.setEliminado( sucursal.isEliminado() );
        }
        sucursalShortDto.setNombre( sucursal.getNombre() );
        sucursalShortDto.setHorarioApertura( sucursal.getHorarioApertura() );
        sucursalShortDto.setHorarioCierre( sucursal.getHorarioCierre() );
        sucursalShortDto.setEsCasaMatriz( sucursal.getEsCasaMatriz() );
        sucursalShortDto.setDomicilio( domicilioToDomicilioDto( sucursal.getDomicilio() ) );
        sucursalShortDto.setImagenes( imagenSucursalSetToImagenSucursalDtoList( sucursal.getImagenes() ) );

        return sucursalShortDto;
    }

    protected Set<SucursalShortDto> sucursalSetToSucursalShortDtoSet(Set<Sucursal> set) {
        if ( set == null ) {
            return null;
        }

        Set<SucursalShortDto> set1 = new LinkedHashSet<SucursalShortDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sucursal sucursal : set ) {
            set1.add( sucursalToSucursalShortDto( sucursal ) );
        }

        return set1;
    }
}
