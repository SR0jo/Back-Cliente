package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.services.CategoriaService;
import com.example.buensaborback.domain.dto.ArticuloInsumo.ArticuloInsumoCreateDto;
import com.example.buensaborback.domain.dto.ArticuloInsumo.ArticuloInsumoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoEditDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaShortDto;
import com.example.buensaborback.domain.dto.Domicilio.DomicilioDto;
import com.example.buensaborback.domain.dto.ImagenArticuloDto.ImagenArticuloDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Localidad.LocalidadDto;
import com.example.buensaborback.domain.dto.Pais.PaisDto;
import com.example.buensaborback.domain.dto.Provincia.ProvinciaDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalShortDto;
import com.example.buensaborback.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import com.example.buensaborback.domain.dto.UnidadMedida.UnidadMedidaDto;
import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.domain.entities.ArticuloManufacturadoDetalle;
import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.domain.entities.ImagenArticulo;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Localidad;
import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.domain.entities.Provincia;
import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.domain.entities.UnidadMedida;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T20:34:25-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ArticuloManufacturadoMapperImpl implements ArticuloManufacturadoMapper {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public ArticuloManufacturadoDto toDTO(ArticuloManufacturado source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturadoDto articuloManufacturadoDto = new ArticuloManufacturadoDto();

        articuloManufacturadoDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            articuloManufacturadoDto.setEliminado( source.isEliminado() );
        }
        articuloManufacturadoDto.setDenominacion( source.getDenominacion() );
        articuloManufacturadoDto.setPrecioVenta( source.getPrecioVenta() );
        articuloManufacturadoDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( source.getUnidadMedida() ) );
        articuloManufacturadoDto.setCategoria( categoriaToCategoriaDto( source.getCategoria() ) );
        articuloManufacturadoDto.setImagenes( imagenArticuloSetToImagenArticuloDtoList( source.getImagenes() ) );
        articuloManufacturadoDto.setDescripcion( source.getDescripcion() );
        articuloManufacturadoDto.setTiempoEstimadoMinutos( source.getTiempoEstimadoMinutos() );
        articuloManufacturadoDto.setPreparacion( source.getPreparacion() );
        articuloManufacturadoDto.setArticuloManufacturadoDetalles( articuloManufacturadoDetalleSetToArticuloManufacturadoDetalleDtoSet( source.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturadoDto;
    }

    @Override
    public ArticuloManufacturado toEntity(ArticuloManufacturadoDto source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturado.ArticuloManufacturadoBuilder<?, ?> articuloManufacturado = ArticuloManufacturado.builder();

        articuloManufacturado.id( source.getId() );
        articuloManufacturado.eliminado( source.isEliminado() );
        articuloManufacturado.denominacion( source.getDenominacion() );
        articuloManufacturado.precioVenta( source.getPrecioVenta() );
        articuloManufacturado.imagenes( imagenArticuloDtoListToImagenArticuloSet( source.getImagenes() ) );
        articuloManufacturado.unidadMedida( unidadMedidaDtoToUnidadMedida( source.getUnidadMedida() ) );
        articuloManufacturado.categoria( categoriaDtoToCategoria( source.getCategoria() ) );
        articuloManufacturado.descripcion( source.getDescripcion() );
        articuloManufacturado.tiempoEstimadoMinutos( source.getTiempoEstimadoMinutos() );
        articuloManufacturado.preparacion( source.getPreparacion() );
        articuloManufacturado.articuloManufacturadoDetalles( articuloManufacturadoDetalleDtoSetToArticuloManufacturadoDetalleSet( source.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturado.build();
    }

    @Override
    public ArticuloManufacturado toUpdate(ArticuloManufacturado entity, ArticuloManufacturadoEditDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setDenominacion( source.getDenominacion() );
        entity.setPrecioVenta( source.getPrecioVenta() );
        if ( entity.getImagenes() != null ) {
            Set<ImagenArticulo> set = imagenArticuloDtoListToImagenArticuloSet( source.getImagenes() );
            if ( set != null ) {
                entity.getImagenes().clear();
                entity.getImagenes().addAll( set );
            }
            else {
                entity.setImagenes( null );
            }
        }
        else {
            Set<ImagenArticulo> set = imagenArticuloDtoListToImagenArticuloSet( source.getImagenes() );
            if ( set != null ) {
                entity.setImagenes( set );
            }
        }
        if ( source.getUnidadMedida() != null ) {
            if ( entity.getUnidadMedida() == null ) {
                entity.setUnidadMedida( UnidadMedida.builder().build() );
            }
            unidadMedidaCreateDtoToUnidadMedida( source.getUnidadMedida(), entity.getUnidadMedida() );
        }
        else {
            entity.setUnidadMedida( null );
        }
        entity.setDescripcion( source.getDescripcion() );
        entity.setTiempoEstimadoMinutos( source.getTiempoEstimadoMinutos() );
        entity.setPreparacion( source.getPreparacion() );
        if ( entity.getArticuloManufacturadoDetalles() != null ) {
            Set<ArticuloManufacturadoDetalle> set1 = articuloManufacturadoDetalleCreateDtoSetToArticuloManufacturadoDetalleSet( source.getArticuloManufacturadoDetalles() );
            if ( set1 != null ) {
                entity.getArticuloManufacturadoDetalles().clear();
                entity.getArticuloManufacturadoDetalles().addAll( set1 );
            }
            else {
                entity.setArticuloManufacturadoDetalles( null );
            }
        }
        else {
            Set<ArticuloManufacturadoDetalle> set1 = articuloManufacturadoDetalleCreateDtoSetToArticuloManufacturadoDetalleSet( source.getArticuloManufacturadoDetalles() );
            if ( set1 != null ) {
                entity.setArticuloManufacturadoDetalles( set1 );
            }
        }

        return entity;
    }

    @Override
    public List<ArticuloManufacturadoDto> toDTOsList(List<ArticuloManufacturado> source) {
        if ( source == null ) {
            return null;
        }

        List<ArticuloManufacturadoDto> list = new ArrayList<ArticuloManufacturadoDto>( source.size() );
        for ( ArticuloManufacturado articuloManufacturado : source ) {
            list.add( toDTO( articuloManufacturado ) );
        }

        return list;
    }

    @Override
    public ArticuloManufacturado toEntityCreate(ArticuloManufacturadoCreateDto source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturado.ArticuloManufacturadoBuilder<?, ?> articuloManufacturado = ArticuloManufacturado.builder();

        articuloManufacturado.categoria( categoriaService.getById( source.getIdCategoria() ) );
        articuloManufacturado.id( source.getId() );
        articuloManufacturado.eliminado( source.isEliminado() );
        articuloManufacturado.denominacion( source.getDenominacion() );
        articuloManufacturado.precioVenta( source.getPrecioVenta() );
        articuloManufacturado.imagenes( imagenArticuloDtoListToImagenArticuloSet( source.getImagenes() ) );
        articuloManufacturado.unidadMedida( unidadMedidaCreateDtoToUnidadMedida1( source.getUnidadMedida() ) );
        articuloManufacturado.descripcion( source.getDescripcion() );
        articuloManufacturado.tiempoEstimadoMinutos( source.getTiempoEstimadoMinutos() );
        articuloManufacturado.preparacion( source.getPreparacion() );
        articuloManufacturado.articuloManufacturadoDetalles( articuloManufacturadoDetalleCreateDtoSetToArticuloManufacturadoDetalleSet( source.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturado.build();
    }

    @Override
    public ArticuloManufacturado toUpdate(ArticuloManufacturadoEditDto source) {
        if ( source == null ) {
            return null;
        }

        ArticuloManufacturado.ArticuloManufacturadoBuilder<?, ?> articuloManufacturado = ArticuloManufacturado.builder();

        articuloManufacturado.categoria( categoriaService.getById( source.getIdCategoria() ) );
        articuloManufacturado.id( source.getId() );
        articuloManufacturado.eliminado( source.isEliminado() );
        articuloManufacturado.denominacion( source.getDenominacion() );
        articuloManufacturado.precioVenta( source.getPrecioVenta() );
        articuloManufacturado.imagenes( imagenArticuloDtoListToImagenArticuloSet( source.getImagenes() ) );
        articuloManufacturado.unidadMedida( unidadMedidaCreateDtoToUnidadMedida1( source.getUnidadMedida() ) );
        articuloManufacturado.descripcion( source.getDescripcion() );
        articuloManufacturado.tiempoEstimadoMinutos( source.getTiempoEstimadoMinutos() );
        articuloManufacturado.preparacion( source.getPreparacion() );
        articuloManufacturado.articuloManufacturadoDetalles( articuloManufacturadoDetalleCreateDtoSetToArticuloManufacturadoDetalleSet( source.getArticuloManufacturadoDetalles() ) );

        return articuloManufacturado.build();
    }

    protected UnidadMedidaDto unidadMedidaToUnidadMedidaDto(UnidadMedida unidadMedida) {
        if ( unidadMedida == null ) {
            return null;
        }

        UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();

        unidadMedidaDto.setId( unidadMedida.getId() );
        if ( unidadMedida.isEliminado() != null ) {
            unidadMedidaDto.setEliminado( unidadMedida.isEliminado() );
        }
        unidadMedidaDto.setDenominacion( unidadMedida.getDenominacion() );

        return unidadMedidaDto;
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

    protected Set<CategoriaShortDto> categoriaSetToCategoriaShortDtoSet(Set<Categoria> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoriaShortDto> set1 = new LinkedHashSet<CategoriaShortDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Categoria categoria : set ) {
            set1.add( categoriaToCategoriaShortDto( categoria ) );
        }

        return set1;
    }

    protected CategoriaShortDto categoriaToCategoriaShortDto(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaShortDto categoriaShortDto = new CategoriaShortDto();

        categoriaShortDto.setId( categoria.getId() );
        if ( categoria.isEliminado() != null ) {
            categoriaShortDto.setEliminado( categoria.isEliminado() );
        }
        categoriaShortDto.setDenominacion( categoria.getDenominacion() );
        categoriaShortDto.setEsInsumo( categoria.isEsInsumo() );
        categoriaShortDto.setSubCategorias( categoriaSetToCategoriaShortDtoSet( categoria.getSubCategorias() ) );
        categoriaShortDto.setEsPadre( categoria.isEsPadre() );

        return categoriaShortDto;
    }

    protected CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDto categoriaDto = new CategoriaDto();

        categoriaDto.setId( categoria.getId() );
        if ( categoria.isEliminado() != null ) {
            categoriaDto.setEliminado( categoria.isEliminado() );
        }
        categoriaDto.setDenominacion( categoria.getDenominacion() );
        categoriaDto.setEsInsumo( categoria.isEsInsumo() );
        categoriaDto.setEsPadre( categoria.isEsPadre() );
        categoriaDto.setSucursales( sucursalSetToSucursalShortDtoSet( categoria.getSucursales() ) );
        categoriaDto.setSubCategorias( categoriaSetToCategoriaShortDtoSet( categoria.getSubCategorias() ) );

        return categoriaDto;
    }

    protected ImagenArticuloDto imagenArticuloToImagenArticuloDto(ImagenArticulo imagenArticulo) {
        if ( imagenArticulo == null ) {
            return null;
        }

        ImagenArticuloDto imagenArticuloDto = new ImagenArticuloDto();

        imagenArticuloDto.setName( imagenArticulo.getName() );
        imagenArticuloDto.setUrl( imagenArticulo.getUrl() );

        return imagenArticuloDto;
    }

    protected List<ImagenArticuloDto> imagenArticuloSetToImagenArticuloDtoList(Set<ImagenArticulo> set) {
        if ( set == null ) {
            return null;
        }

        List<ImagenArticuloDto> list = new ArrayList<ImagenArticuloDto>( set.size() );
        for ( ImagenArticulo imagenArticulo : set ) {
            list.add( imagenArticuloToImagenArticuloDto( imagenArticulo ) );
        }

        return list;
    }

    protected ArticuloInsumoDto articuloInsumoToArticuloInsumoDto(ArticuloInsumo articuloInsumo) {
        if ( articuloInsumo == null ) {
            return null;
        }

        ArticuloInsumoDto articuloInsumoDto = new ArticuloInsumoDto();

        articuloInsumoDto.setId( articuloInsumo.getId() );
        if ( articuloInsumo.isEliminado() != null ) {
            articuloInsumoDto.setEliminado( articuloInsumo.isEliminado() );
        }
        articuloInsumoDto.setDenominacion( articuloInsumo.getDenominacion() );
        articuloInsumoDto.setPrecioVenta( articuloInsumo.getPrecioVenta() );
        articuloInsumoDto.setUnidadMedida( unidadMedidaToUnidadMedidaDto( articuloInsumo.getUnidadMedida() ) );
        articuloInsumoDto.setCategoria( categoriaToCategoriaDto( articuloInsumo.getCategoria() ) );
        articuloInsumoDto.setPrecioCompra( articuloInsumo.getPrecioCompra() );
        articuloInsumoDto.setStockActual( articuloInsumo.getStockActual() );
        articuloInsumoDto.setStockMinimo( articuloInsumo.getStockMinimo() );
        articuloInsumoDto.setStockMaximo( articuloInsumo.getStockMaximo() );
        articuloInsumoDto.setEsParaElaborar( articuloInsumo.getEsParaElaborar() );
        articuloInsumoDto.setImagenes( imagenArticuloSetToImagenArticuloDtoList( articuloInsumo.getImagenes() ) );

        return articuloInsumoDto;
    }

    protected ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleToArticuloManufacturadoDetalleDto(ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        if ( articuloManufacturadoDetalle == null ) {
            return null;
        }

        ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto = new ArticuloManufacturadoDetalleDto();

        articuloManufacturadoDetalleDto.setId( articuloManufacturadoDetalle.getId() );
        if ( articuloManufacturadoDetalle.isEliminado() != null ) {
            articuloManufacturadoDetalleDto.setEliminado( articuloManufacturadoDetalle.isEliminado() );
        }
        articuloManufacturadoDetalleDto.setCantidad( articuloManufacturadoDetalle.getCantidad() );
        articuloManufacturadoDetalleDto.setArticuloInsumo( articuloInsumoToArticuloInsumoDto( articuloManufacturadoDetalle.getArticuloInsumo() ) );

        return articuloManufacturadoDetalleDto;
    }

    protected Set<ArticuloManufacturadoDetalleDto> articuloManufacturadoDetalleSetToArticuloManufacturadoDetalleDtoSet(Set<ArticuloManufacturadoDetalle> set) {
        if ( set == null ) {
            return null;
        }

        Set<ArticuloManufacturadoDetalleDto> set1 = new LinkedHashSet<ArticuloManufacturadoDetalleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ArticuloManufacturadoDetalle articuloManufacturadoDetalle : set ) {
            set1.add( articuloManufacturadoDetalleToArticuloManufacturadoDetalleDto( articuloManufacturadoDetalle ) );
        }

        return set1;
    }

    protected ImagenArticulo imagenArticuloDtoToImagenArticulo(ImagenArticuloDto imagenArticuloDto) {
        if ( imagenArticuloDto == null ) {
            return null;
        }

        ImagenArticulo.ImagenArticuloBuilder<?, ?> imagenArticulo = ImagenArticulo.builder();

        imagenArticulo.name( imagenArticuloDto.getName() );
        imagenArticulo.url( imagenArticuloDto.getUrl() );

        return imagenArticulo.build();
    }

    protected Set<ImagenArticulo> imagenArticuloDtoListToImagenArticuloSet(List<ImagenArticuloDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<ImagenArticulo> set = new LinkedHashSet<ImagenArticulo>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ImagenArticuloDto imagenArticuloDto : list ) {
            set.add( imagenArticuloDtoToImagenArticulo( imagenArticuloDto ) );
        }

        return set;
    }

    protected UnidadMedida unidadMedidaDtoToUnidadMedida(UnidadMedidaDto unidadMedidaDto) {
        if ( unidadMedidaDto == null ) {
            return null;
        }

        UnidadMedida.UnidadMedidaBuilder<?, ?> unidadMedida = UnidadMedida.builder();

        unidadMedida.id( unidadMedidaDto.getId() );
        unidadMedida.eliminado( unidadMedidaDto.isEliminado() );
        unidadMedida.denominacion( unidadMedidaDto.getDenominacion() );

        return unidadMedida.build();
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

    protected Provincia provinciaDtoToProvincia(ProvinciaDto provinciaDto) {
        if ( provinciaDto == null ) {
            return null;
        }

        Provincia.ProvinciaBuilder<?, ?> provincia = Provincia.builder();

        provincia.id( provinciaDto.getId() );
        provincia.eliminado( provinciaDto.isEliminado() );
        provincia.nombre( provinciaDto.getNombre() );
        provincia.pais( paisDtoToPais( provinciaDto.getPais() ) );

        return provincia.build();
    }

    protected Localidad localidadDtoToLocalidad(LocalidadDto localidadDto) {
        if ( localidadDto == null ) {
            return null;
        }

        Localidad.LocalidadBuilder<?, ?> localidad = Localidad.builder();

        localidad.id( localidadDto.getId() );
        localidad.eliminado( localidadDto.isEliminado() );
        localidad.nombre( localidadDto.getNombre() );
        localidad.provincia( provinciaDtoToProvincia( localidadDto.getProvincia() ) );

        return localidad.build();
    }

    protected Domicilio domicilioDtoToDomicilio(DomicilioDto domicilioDto) {
        if ( domicilioDto == null ) {
            return null;
        }

        Domicilio.DomicilioBuilder<?, ?> domicilio = Domicilio.builder();

        domicilio.id( domicilioDto.getId() );
        domicilio.eliminado( domicilioDto.isEliminado() );
        domicilio.calle( domicilioDto.getCalle() );
        domicilio.numero( domicilioDto.getNumero() );
        domicilio.cp( domicilioDto.getCp() );
        domicilio.piso( domicilioDto.getPiso() );
        domicilio.nroDpto( domicilioDto.getNroDpto() );
        domicilio.localidad( localidadDtoToLocalidad( domicilioDto.getLocalidad() ) );

        return domicilio.build();
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

    protected Sucursal sucursalShortDtoToSucursal(SucursalShortDto sucursalShortDto) {
        if ( sucursalShortDto == null ) {
            return null;
        }

        Sucursal.SucursalBuilder<?, ?> sucursal = Sucursal.builder();

        sucursal.id( sucursalShortDto.getId() );
        sucursal.eliminado( sucursalShortDto.isEliminado() );
        sucursal.nombre( sucursalShortDto.getNombre() );
        sucursal.horarioApertura( sucursalShortDto.getHorarioApertura() );
        sucursal.horarioCierre( sucursalShortDto.getHorarioCierre() );
        sucursal.esCasaMatriz( sucursalShortDto.getEsCasaMatriz() );
        sucursal.domicilio( domicilioDtoToDomicilio( sucursalShortDto.getDomicilio() ) );
        sucursal.imagenes( imagenSucursalDtoListToImagenSucursalSet( sucursalShortDto.getImagenes() ) );

        return sucursal.build();
    }

    protected Set<Sucursal> sucursalShortDtoSetToSucursalSet(Set<SucursalShortDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Sucursal> set1 = new LinkedHashSet<Sucursal>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( SucursalShortDto sucursalShortDto : set ) {
            set1.add( sucursalShortDtoToSucursal( sucursalShortDto ) );
        }

        return set1;
    }

    protected Set<Categoria> categoriaShortDtoSetToCategoriaSet(Set<CategoriaShortDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Categoria> set1 = new LinkedHashSet<Categoria>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoriaShortDto categoriaShortDto : set ) {
            set1.add( categoriaShortDtoToCategoria( categoriaShortDto ) );
        }

        return set1;
    }

    protected Categoria categoriaShortDtoToCategoria(CategoriaShortDto categoriaShortDto) {
        if ( categoriaShortDto == null ) {
            return null;
        }

        Categoria.CategoriaBuilder<?, ?> categoria = Categoria.builder();

        categoria.id( categoriaShortDto.getId() );
        categoria.eliminado( categoriaShortDto.isEliminado() );
        categoria.denominacion( categoriaShortDto.getDenominacion() );
        categoria.esInsumo( categoriaShortDto.isEsInsumo() );
        categoria.esPadre( categoriaShortDto.isEsPadre() );
        categoria.subCategorias( categoriaShortDtoSetToCategoriaSet( categoriaShortDto.getSubCategorias() ) );

        return categoria.build();
    }

    protected Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        Categoria.CategoriaBuilder<?, ?> categoria = Categoria.builder();

        categoria.id( categoriaDto.getId() );
        categoria.eliminado( categoriaDto.isEliminado() );
        categoria.denominacion( categoriaDto.getDenominacion() );
        categoria.esInsumo( categoriaDto.isEsInsumo() );
        categoria.esPadre( categoriaDto.isEsPadre() );
        categoria.sucursales( sucursalShortDtoSetToSucursalSet( categoriaDto.getSucursales() ) );
        categoria.subCategorias( categoriaShortDtoSetToCategoriaSet( categoriaDto.getSubCategorias() ) );

        return categoria.build();
    }

    protected ArticuloInsumo articuloInsumoDtoToArticuloInsumo(ArticuloInsumoDto articuloInsumoDto) {
        if ( articuloInsumoDto == null ) {
            return null;
        }

        ArticuloInsumo.ArticuloInsumoBuilder<?, ?> articuloInsumo = ArticuloInsumo.builder();

        articuloInsumo.id( articuloInsumoDto.getId() );
        articuloInsumo.eliminado( articuloInsumoDto.isEliminado() );
        articuloInsumo.denominacion( articuloInsumoDto.getDenominacion() );
        articuloInsumo.precioVenta( articuloInsumoDto.getPrecioVenta() );
        articuloInsumo.imagenes( imagenArticuloDtoListToImagenArticuloSet( articuloInsumoDto.getImagenes() ) );
        articuloInsumo.unidadMedida( unidadMedidaDtoToUnidadMedida( articuloInsumoDto.getUnidadMedida() ) );
        articuloInsumo.categoria( categoriaDtoToCategoria( articuloInsumoDto.getCategoria() ) );
        articuloInsumo.precioCompra( articuloInsumoDto.getPrecioCompra() );
        articuloInsumo.stockActual( articuloInsumoDto.getStockActual() );
        articuloInsumo.stockMinimo( articuloInsumoDto.getStockMinimo() );
        articuloInsumo.stockMaximo( articuloInsumoDto.getStockMaximo() );
        articuloInsumo.esParaElaborar( articuloInsumoDto.getEsParaElaborar() );

        return articuloInsumo.build();
    }

    protected ArticuloManufacturadoDetalle articuloManufacturadoDetalleDtoToArticuloManufacturadoDetalle(ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto) {
        if ( articuloManufacturadoDetalleDto == null ) {
            return null;
        }

        ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleBuilder<?, ?> articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder();

        articuloManufacturadoDetalle.id( articuloManufacturadoDetalleDto.getId() );
        articuloManufacturadoDetalle.eliminado( articuloManufacturadoDetalleDto.isEliminado() );
        articuloManufacturadoDetalle.cantidad( articuloManufacturadoDetalleDto.getCantidad() );
        articuloManufacturadoDetalle.articuloInsumo( articuloInsumoDtoToArticuloInsumo( articuloManufacturadoDetalleDto.getArticuloInsumo() ) );

        return articuloManufacturadoDetalle.build();
    }

    protected Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalleDtoSetToArticuloManufacturadoDetalleSet(Set<ArticuloManufacturadoDetalleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ArticuloManufacturadoDetalle> set1 = new LinkedHashSet<ArticuloManufacturadoDetalle>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto : set ) {
            set1.add( articuloManufacturadoDetalleDtoToArticuloManufacturadoDetalle( articuloManufacturadoDetalleDto ) );
        }

        return set1;
    }

    protected void unidadMedidaCreateDtoToUnidadMedida(UnidadMedidaCreateDto unidadMedidaCreateDto, UnidadMedida mappingTarget) {
        if ( unidadMedidaCreateDto == null ) {
            return;
        }

        mappingTarget.setId( unidadMedidaCreateDto.getId() );
        mappingTarget.setEliminado( unidadMedidaCreateDto.isEliminado() );
        mappingTarget.setDenominacion( unidadMedidaCreateDto.getDenominacion() );
    }

    protected UnidadMedida unidadMedidaCreateDtoToUnidadMedida1(UnidadMedidaCreateDto unidadMedidaCreateDto) {
        if ( unidadMedidaCreateDto == null ) {
            return null;
        }

        UnidadMedida.UnidadMedidaBuilder<?, ?> unidadMedida = UnidadMedida.builder();

        unidadMedida.id( unidadMedidaCreateDto.getId() );
        unidadMedida.eliminado( unidadMedidaCreateDto.isEliminado() );
        unidadMedida.denominacion( unidadMedidaCreateDto.getDenominacion() );

        return unidadMedida.build();
    }

    protected ArticuloInsumo articuloInsumoCreateDtoToArticuloInsumo(ArticuloInsumoCreateDto articuloInsumoCreateDto) {
        if ( articuloInsumoCreateDto == null ) {
            return null;
        }

        ArticuloInsumo.ArticuloInsumoBuilder<?, ?> articuloInsumo = ArticuloInsumo.builder();

        articuloInsumo.id( articuloInsumoCreateDto.getId() );
        articuloInsumo.eliminado( articuloInsumoCreateDto.isEliminado() );
        articuloInsumo.denominacion( articuloInsumoCreateDto.getDenominacion() );
        articuloInsumo.precioVenta( articuloInsumoCreateDto.getPrecioVenta() );
        articuloInsumo.imagenes( imagenArticuloDtoListToImagenArticuloSet( articuloInsumoCreateDto.getImagenes() ) );
        articuloInsumo.unidadMedida( unidadMedidaCreateDtoToUnidadMedida1( articuloInsumoCreateDto.getUnidadMedida() ) );
        articuloInsumo.precioCompra( articuloInsumoCreateDto.getPrecioCompra() );
        articuloInsumo.stockActual( articuloInsumoCreateDto.getStockActual() );
        articuloInsumo.stockMinimo( articuloInsumoCreateDto.getStockMinimo() );
        articuloInsumo.stockMaximo( articuloInsumoCreateDto.getStockMaximo() );
        articuloInsumo.esParaElaborar( articuloInsumoCreateDto.getEsParaElaborar() );

        return articuloInsumo.build();
    }

    protected ArticuloManufacturadoDetalle articuloManufacturadoDetalleCreateDtoToArticuloManufacturadoDetalle(ArticuloManufacturadoDetalleCreateDto articuloManufacturadoDetalleCreateDto) {
        if ( articuloManufacturadoDetalleCreateDto == null ) {
            return null;
        }

        ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleBuilder<?, ?> articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder();

        articuloManufacturadoDetalle.cantidad( articuloManufacturadoDetalleCreateDto.getCantidad() );
        articuloManufacturadoDetalle.articuloInsumo( articuloInsumoCreateDtoToArticuloInsumo( articuloManufacturadoDetalleCreateDto.getArticuloInsumo() ) );

        return articuloManufacturadoDetalle.build();
    }

    protected Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalleCreateDtoSetToArticuloManufacturadoDetalleSet(Set<ArticuloManufacturadoDetalleCreateDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ArticuloManufacturadoDetalle> set1 = new LinkedHashSet<ArticuloManufacturadoDetalle>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ArticuloManufacturadoDetalleCreateDto articuloManufacturadoDetalleCreateDto : set ) {
            set1.add( articuloManufacturadoDetalleCreateDtoToArticuloManufacturadoDetalle( articuloManufacturadoDetalleCreateDto ) );
        }

        return set1;
    }
}
