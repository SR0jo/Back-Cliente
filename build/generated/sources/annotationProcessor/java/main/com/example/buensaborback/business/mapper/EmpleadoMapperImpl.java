package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.services.SucursalService;
import com.example.buensaborback.domain.dto.ArticuloInsumo.ArticuloInsumoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.example.buensaborback.domain.dto.DetallePedido.DetallePedidoDto;
import com.example.buensaborback.domain.dto.Domicilio.DomicilioDto;
import com.example.buensaborback.domain.dto.Empleado.EmpleadoCreateDto;
import com.example.buensaborback.domain.dto.Empleado.EmpleadoDto;
import com.example.buensaborback.domain.dto.Empresa.EmpresaDto;
import com.example.buensaborback.domain.dto.ImagenEmpresa.ImagenEmpresaDto;
import com.example.buensaborback.domain.dto.ImagenPromocion.ImagenPromocionDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Localidad.LocalidadDto;
import com.example.buensaborback.domain.dto.Pais.PaisDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoShortDto;
import com.example.buensaborback.domain.dto.Promocion.PromocionDto;
import com.example.buensaborback.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.example.buensaborback.domain.dto.Provincia.ProvinciaDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalShortDto;
import com.example.buensaborback.domain.dto.UsuarioEmpleado.UsuarioEmpleadoCreateDto;
import com.example.buensaborback.domain.dto.UsuarioEmpleado.UsuarioEmpleadoDto;
import com.example.buensaborback.domain.entities.DetallePedido;
import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.ImagenEmpresa;
import com.example.buensaborback.domain.entities.ImagenPromocion;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Localidad;
import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.domain.entities.Promocion;
import com.example.buensaborback.domain.entities.PromocionDetalle;
import com.example.buensaborback.domain.entities.Provincia;
import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.domain.entities.UsuarioEmpleado;
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
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Autowired
    private SucursalService sucursalService;

    @Override
    public EmpleadoDto toDTO(Empleado source) {
        if ( source == null ) {
            return null;
        }

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            empleadoDto.setEliminado( source.isEliminado() );
        }
        empleadoDto.setNombre( source.getNombre() );
        empleadoDto.setApellido( source.getApellido() );
        empleadoDto.setTelefono( source.getTelefono() );
        empleadoDto.setEmail( source.getEmail() );
        empleadoDto.setUsuario( usuarioEmpleadoToUsuarioEmpleadoDto( source.getUsuario() ) );
        empleadoDto.setTipoEmpleado( source.getTipoEmpleado() );
        empleadoDto.setPedidos( pedidoSetToPedidoShortDtoSet( source.getPedidos() ) );
        empleadoDto.setSucursal( sucursalToSucursalDto( source.getSucursal() ) );

        return empleadoDto;
    }

    @Override
    public Empleado toEntity(EmpleadoDto source) {
        if ( source == null ) {
            return null;
        }

        Empleado.EmpleadoBuilder<?, ?> empleado = Empleado.builder();

        empleado.id( source.getId() );
        empleado.eliminado( source.isEliminado() );
        empleado.nombre( source.getNombre() );
        empleado.apellido( source.getApellido() );
        empleado.telefono( source.getTelefono() );
        empleado.email( source.getEmail() );
        empleado.usuario( usuarioEmpleadoDtoToUsuarioEmpleado( source.getUsuario() ) );
        empleado.tipoEmpleado( source.getTipoEmpleado() );
        empleado.pedidos( pedidoShortDtoSetToPedidoSet( source.getPedidos() ) );
        empleado.sucursal( sucursalDtoToSucursal( source.getSucursal() ) );

        return empleado.build();
    }

    @Override
    public Empleado toUpdate(Empleado entity, EmpleadoCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setNombre( source.getNombre() );
        entity.setApellido( source.getApellido() );
        entity.setTelefono( source.getTelefono() );
        entity.setEmail( source.getEmail() );
        if ( source.getUsuario() != null ) {
            if ( entity.getUsuario() == null ) {
                entity.setUsuario( UsuarioEmpleado.builder().build() );
            }
            usuarioEmpleadoCreateDtoToUsuarioEmpleado( source.getUsuario(), entity.getUsuario() );
        }
        else {
            entity.setUsuario( null );
        }
        entity.setTipoEmpleado( source.getTipoEmpleado() );

        return entity;
    }

    @Override
    public List<EmpleadoDto> toDTOsList(List<Empleado> source) {
        if ( source == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( source.size() );
        for ( Empleado empleado : source ) {
            list.add( toDTO( empleado ) );
        }

        return list;
    }

    @Override
    public Empleado toEntityCreate(EmpleadoCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Empleado.EmpleadoBuilder<?, ?> empleado = Empleado.builder();

        empleado.sucursal( sucursalService.getById( source.getIdSucursal() ) );
        empleado.id( source.getId() );
        empleado.eliminado( source.isEliminado() );
        empleado.nombre( source.getNombre() );
        empleado.apellido( source.getApellido() );
        empleado.telefono( source.getTelefono() );
        empleado.email( source.getEmail() );
        empleado.usuario( usuarioEmpleadoCreateDtoToUsuarioEmpleado1( source.getUsuario() ) );
        empleado.tipoEmpleado( source.getTipoEmpleado() );

        return empleado.build();
    }

    @Override
    public Empleado toUpdate(EmpleadoCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Empleado.EmpleadoBuilder<?, ?> empleado = Empleado.builder();

        empleado.sucursal( sucursalService.getById( source.getIdSucursal() ) );
        empleado.id( source.getId() );
        empleado.eliminado( source.isEliminado() );
        empleado.nombre( source.getNombre() );
        empleado.apellido( source.getApellido() );
        empleado.telefono( source.getTelefono() );
        empleado.email( source.getEmail() );
        empleado.usuario( usuarioEmpleadoCreateDtoToUsuarioEmpleado1( source.getUsuario() ) );
        empleado.tipoEmpleado( source.getTipoEmpleado() );

        return empleado.build();
    }

    protected UsuarioEmpleadoDto usuarioEmpleadoToUsuarioEmpleadoDto(UsuarioEmpleado usuarioEmpleado) {
        if ( usuarioEmpleado == null ) {
            return null;
        }

        UsuarioEmpleadoDto usuarioEmpleadoDto = new UsuarioEmpleadoDto();

        usuarioEmpleadoDto.setId( usuarioEmpleado.getId() );
        if ( usuarioEmpleado.isEliminado() != null ) {
            usuarioEmpleadoDto.setEliminado( usuarioEmpleado.isEliminado() );
        }
        usuarioEmpleadoDto.setAuth0Id( usuarioEmpleado.getAuth0Id() );
        usuarioEmpleadoDto.setUserName( usuarioEmpleado.getUserName() );

        return usuarioEmpleadoDto;
    }

    protected ImagenPromocionDto imagenPromocionToImagenPromocionDto(ImagenPromocion imagenPromocion) {
        if ( imagenPromocion == null ) {
            return null;
        }

        ImagenPromocionDto imagenPromocionDto = new ImagenPromocionDto();

        imagenPromocionDto.setName( imagenPromocion.getName() );
        imagenPromocionDto.setUrl( imagenPromocion.getUrl() );

        return imagenPromocionDto;
    }

    protected List<ImagenPromocionDto> imagenPromocionSetToImagenPromocionDtoList(Set<ImagenPromocion> set) {
        if ( set == null ) {
            return null;
        }

        List<ImagenPromocionDto> list = new ArrayList<ImagenPromocionDto>( set.size() );
        for ( ImagenPromocion imagenPromocion : set ) {
            list.add( imagenPromocionToImagenPromocionDto( imagenPromocion ) );
        }

        return list;
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

    protected PromocionDetalleDto promocionDetalleToPromocionDetalleDto(PromocionDetalle promocionDetalle) {
        if ( promocionDetalle == null ) {
            return null;
        }

        Integer cantidad = null;

        cantidad = promocionDetalle.getCantidad();

        ArticuloInsumoDto insumos = null;
        ArticuloManufacturadoDto articulosManufacturados = null;

        PromocionDetalleDto promocionDetalleDto = new PromocionDetalleDto( cantidad, insumos, articulosManufacturados );

        promocionDetalleDto.setId( promocionDetalle.getId() );
        if ( promocionDetalle.isEliminado() != null ) {
            promocionDetalleDto.setEliminado( promocionDetalle.isEliminado() );
        }

        return promocionDetalleDto;
    }

    protected Set<PromocionDetalleDto> promocionDetalleSetToPromocionDetalleDtoSet(Set<PromocionDetalle> set) {
        if ( set == null ) {
            return null;
        }

        Set<PromocionDetalleDto> set1 = new LinkedHashSet<PromocionDetalleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PromocionDetalle promocionDetalle : set ) {
            set1.add( promocionDetalleToPromocionDetalleDto( promocionDetalle ) );
        }

        return set1;
    }

    protected PromocionDto promocionToPromocionDto(Promocion promocion) {
        if ( promocion == null ) {
            return null;
        }

        PromocionDto promocionDto = new PromocionDto();

        promocionDto.setId( promocion.getId() );
        if ( promocion.isEliminado() != null ) {
            promocionDto.setEliminado( promocion.isEliminado() );
        }
        promocionDto.setDenominacion( promocion.getDenominacion() );
        promocionDto.setFechaDesde( promocion.getFechaDesde() );
        promocionDto.setFechaHasta( promocion.getFechaHasta() );
        promocionDto.setHoraDesde( promocion.getHoraDesde() );
        promocionDto.setHoraHasta( promocion.getHoraHasta() );
        promocionDto.setPrecioPromocional( promocion.getPrecioPromocional() );
        promocionDto.setImagenes( imagenPromocionSetToImagenPromocionDtoList( promocion.getImagenes() ) );
        promocionDto.setSucursales( sucursalSetToSucursalShortDtoSet( promocion.getSucursales() ) );
        promocionDto.setDetalles( promocionDetalleSetToPromocionDetalleDtoSet( promocion.getDetalles() ) );
        promocionDto.setDescripcionDescuento( promocion.getDescripcionDescuento() );
        promocionDto.setTipoPromocion( promocion.getTipoPromocion() );

        return promocionDto;
    }

    protected DetallePedidoDto detallePedidoToDetallePedidoDto(DetallePedido detallePedido) {
        if ( detallePedido == null ) {
            return null;
        }

        DetallePedidoDto detallePedidoDto = new DetallePedidoDto();

        detallePedidoDto.setId( detallePedido.getId() );
        if ( detallePedido.isEliminado() != null ) {
            detallePedidoDto.setEliminado( detallePedido.isEliminado() );
        }
        detallePedidoDto.setCantidad( detallePedido.getCantidad() );
        detallePedidoDto.setSubTotal( detallePedido.getSubTotal() );
        detallePedidoDto.setPromocion( promocionToPromocionDto( detallePedido.getPromocion() ) );

        return detallePedidoDto;
    }

    protected Set<DetallePedidoDto> detallePedidoSetToDetallePedidoDtoSet(Set<DetallePedido> set) {
        if ( set == null ) {
            return null;
        }

        Set<DetallePedidoDto> set1 = new LinkedHashSet<DetallePedidoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DetallePedido detallePedido : set ) {
            set1.add( detallePedidoToDetallePedidoDto( detallePedido ) );
        }

        return set1;
    }

    protected PedidoShortDto pedidoToPedidoShortDto(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoShortDto pedidoShortDto = new PedidoShortDto();

        pedidoShortDto.setId( pedido.getId() );
        if ( pedido.isEliminado() != null ) {
            pedidoShortDto.setEliminado( pedido.isEliminado() );
        }
        pedidoShortDto.setDetallesPedido( detallePedidoSetToDetallePedidoDtoSet( pedido.getDetallesPedido() ) );
        pedidoShortDto.setHoraEstimadaFinalizacion( pedido.getHoraEstimadaFinalizacion() );
        pedidoShortDto.setTotal( pedido.getTotal() );
        pedidoShortDto.setTotalCosto( pedido.getTotalCosto() );
        pedidoShortDto.setEstado( pedido.getEstado() );
        pedidoShortDto.setTipoEnvio( pedido.getTipoEnvio() );
        pedidoShortDto.setFormaPago( pedido.getFormaPago() );
        pedidoShortDto.setFechaPedido( pedido.getFechaPedido() );

        return pedidoShortDto;
    }

    protected Set<PedidoShortDto> pedidoSetToPedidoShortDtoSet(Set<Pedido> set) {
        if ( set == null ) {
            return null;
        }

        Set<PedidoShortDto> set1 = new LinkedHashSet<PedidoShortDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Pedido pedido : set ) {
            set1.add( pedidoToPedidoShortDto( pedido ) );
        }

        return set1;
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

    protected SucursalDto sucursalToSucursalDto(Sucursal sucursal) {
        if ( sucursal == null ) {
            return null;
        }

        SucursalDto sucursalDto = new SucursalDto();

        sucursalDto.setId( sucursal.getId() );
        if ( sucursal.isEliminado() != null ) {
            sucursalDto.setEliminado( sucursal.isEliminado() );
        }
        sucursalDto.setNombre( sucursal.getNombre() );
        sucursalDto.setHorarioApertura( sucursal.getHorarioApertura() );
        sucursalDto.setHorarioCierre( sucursal.getHorarioCierre() );
        sucursalDto.setEsCasaMatriz( sucursal.getEsCasaMatriz() );
        sucursalDto.setDomicilio( domicilioToDomicilioDto( sucursal.getDomicilio() ) );
        sucursalDto.setEmpresa( empresaToEmpresaDto( sucursal.getEmpresa() ) );
        sucursalDto.setImagenes( imagenSucursalSetToImagenSucursalDtoList( sucursal.getImagenes() ) );

        return sucursalDto;
    }

    protected UsuarioEmpleado usuarioEmpleadoDtoToUsuarioEmpleado(UsuarioEmpleadoDto usuarioEmpleadoDto) {
        if ( usuarioEmpleadoDto == null ) {
            return null;
        }

        UsuarioEmpleado.UsuarioEmpleadoBuilder usuarioEmpleado = UsuarioEmpleado.builder();

        usuarioEmpleado.auth0Id( usuarioEmpleadoDto.getAuth0Id() );
        usuarioEmpleado.userName( usuarioEmpleadoDto.getUserName() );

        return usuarioEmpleado.build();
    }

    protected ImagenPromocion imagenPromocionDtoToImagenPromocion(ImagenPromocionDto imagenPromocionDto) {
        if ( imagenPromocionDto == null ) {
            return null;
        }

        ImagenPromocion.ImagenPromocionBuilder<?, ?> imagenPromocion = ImagenPromocion.builder();

        imagenPromocion.name( imagenPromocionDto.getName() );
        imagenPromocion.url( imagenPromocionDto.getUrl() );

        return imagenPromocion.build();
    }

    protected Set<ImagenPromocion> imagenPromocionDtoListToImagenPromocionSet(List<ImagenPromocionDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<ImagenPromocion> set = new LinkedHashSet<ImagenPromocion>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ImagenPromocionDto imagenPromocionDto : list ) {
            set.add( imagenPromocionDtoToImagenPromocion( imagenPromocionDto ) );
        }

        return set;
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

    protected PromocionDetalle promocionDetalleDtoToPromocionDetalle(PromocionDetalleDto promocionDetalleDto) {
        if ( promocionDetalleDto == null ) {
            return null;
        }

        PromocionDetalle.PromocionDetalleBuilder<?, ?> promocionDetalle = PromocionDetalle.builder();

        promocionDetalle.id( promocionDetalleDto.getId() );
        promocionDetalle.eliminado( promocionDetalleDto.isEliminado() );
        promocionDetalle.cantidad( promocionDetalleDto.getCantidad() );

        return promocionDetalle.build();
    }

    protected Set<PromocionDetalle> promocionDetalleDtoSetToPromocionDetalleSet(Set<PromocionDetalleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<PromocionDetalle> set1 = new LinkedHashSet<PromocionDetalle>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PromocionDetalleDto promocionDetalleDto : set ) {
            set1.add( promocionDetalleDtoToPromocionDetalle( promocionDetalleDto ) );
        }

        return set1;
    }

    protected Promocion promocionDtoToPromocion(PromocionDto promocionDto) {
        if ( promocionDto == null ) {
            return null;
        }

        Promocion.PromocionBuilder<?, ?> promocion = Promocion.builder();

        promocion.id( promocionDto.getId() );
        promocion.eliminado( promocionDto.isEliminado() );
        promocion.denominacion( promocionDto.getDenominacion() );
        promocion.fechaDesde( promocionDto.getFechaDesde() );
        promocion.fechaHasta( promocionDto.getFechaHasta() );
        promocion.horaDesde( promocionDto.getHoraDesde() );
        promocion.horaHasta( promocionDto.getHoraHasta() );
        promocion.descripcionDescuento( promocionDto.getDescripcionDescuento() );
        promocion.precioPromocional( promocionDto.getPrecioPromocional() );
        promocion.tipoPromocion( promocionDto.getTipoPromocion() );
        promocion.imagenes( imagenPromocionDtoListToImagenPromocionSet( promocionDto.getImagenes() ) );
        promocion.sucursales( sucursalShortDtoSetToSucursalSet( promocionDto.getSucursales() ) );
        promocion.detalles( promocionDetalleDtoSetToPromocionDetalleSet( promocionDto.getDetalles() ) );

        return promocion.build();
    }

    protected DetallePedido detallePedidoDtoToDetallePedido(DetallePedidoDto detallePedidoDto) {
        if ( detallePedidoDto == null ) {
            return null;
        }

        DetallePedido.DetallePedidoBuilder<?, ?> detallePedido = DetallePedido.builder();

        detallePedido.id( detallePedidoDto.getId() );
        detallePedido.eliminado( detallePedidoDto.isEliminado() );
        detallePedido.cantidad( detallePedidoDto.getCantidad() );
        detallePedido.subTotal( detallePedidoDto.getSubTotal() );
        detallePedido.promocion( promocionDtoToPromocion( detallePedidoDto.getPromocion() ) );

        return detallePedido.build();
    }

    protected Set<DetallePedido> detallePedidoDtoSetToDetallePedidoSet(Set<DetallePedidoDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<DetallePedido> set1 = new LinkedHashSet<DetallePedido>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DetallePedidoDto detallePedidoDto : set ) {
            set1.add( detallePedidoDtoToDetallePedido( detallePedidoDto ) );
        }

        return set1;
    }

    protected Pedido pedidoShortDtoToPedido(PedidoShortDto pedidoShortDto) {
        if ( pedidoShortDto == null ) {
            return null;
        }

        Pedido.PedidoBuilder<?, ?> pedido = Pedido.builder();

        pedido.id( pedidoShortDto.getId() );
        pedido.eliminado( pedidoShortDto.isEliminado() );
        pedido.horaEstimadaFinalizacion( pedidoShortDto.getHoraEstimadaFinalizacion() );
        pedido.total( pedidoShortDto.getTotal() );
        pedido.totalCosto( pedidoShortDto.getTotalCosto() );
        pedido.estado( pedidoShortDto.getEstado() );
        pedido.tipoEnvio( pedidoShortDto.getTipoEnvio() );
        pedido.formaPago( pedidoShortDto.getFormaPago() );
        pedido.fechaPedido( pedidoShortDto.getFechaPedido() );
        pedido.detallesPedido( detallePedidoDtoSetToDetallePedidoSet( pedidoShortDto.getDetallesPedido() ) );

        return pedido.build();
    }

    protected Set<Pedido> pedidoShortDtoSetToPedidoSet(Set<PedidoShortDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Pedido> set1 = new LinkedHashSet<Pedido>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PedidoShortDto pedidoShortDto : set ) {
            set1.add( pedidoShortDtoToPedido( pedidoShortDto ) );
        }

        return set1;
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

    protected Sucursal sucursalDtoToSucursal(SucursalDto sucursalDto) {
        if ( sucursalDto == null ) {
            return null;
        }

        Sucursal.SucursalBuilder<?, ?> sucursal = Sucursal.builder();

        sucursal.id( sucursalDto.getId() );
        sucursal.eliminado( sucursalDto.isEliminado() );
        sucursal.nombre( sucursalDto.getNombre() );
        sucursal.horarioApertura( sucursalDto.getHorarioApertura() );
        sucursal.horarioCierre( sucursalDto.getHorarioCierre() );
        sucursal.esCasaMatriz( sucursalDto.getEsCasaMatriz() );
        sucursal.domicilio( domicilioDtoToDomicilio( sucursalDto.getDomicilio() ) );
        sucursal.empresa( empresaDtoToEmpresa( sucursalDto.getEmpresa() ) );
        sucursal.imagenes( imagenSucursalDtoListToImagenSucursalSet( sucursalDto.getImagenes() ) );

        return sucursal.build();
    }

    protected void usuarioEmpleadoCreateDtoToUsuarioEmpleado(UsuarioEmpleadoCreateDto usuarioEmpleadoCreateDto, UsuarioEmpleado mappingTarget) {
        if ( usuarioEmpleadoCreateDto == null ) {
            return;
        }

        mappingTarget.setId( usuarioEmpleadoCreateDto.getId() );
        mappingTarget.setEliminado( usuarioEmpleadoCreateDto.isEliminado() );
        mappingTarget.setAuth0Id( usuarioEmpleadoCreateDto.getAuth0Id() );
        mappingTarget.setUserName( usuarioEmpleadoCreateDto.getUserName() );
    }

    protected UsuarioEmpleado usuarioEmpleadoCreateDtoToUsuarioEmpleado1(UsuarioEmpleadoCreateDto usuarioEmpleadoCreateDto) {
        if ( usuarioEmpleadoCreateDto == null ) {
            return null;
        }

        UsuarioEmpleado.UsuarioEmpleadoBuilder usuarioEmpleado = UsuarioEmpleado.builder();

        usuarioEmpleado.auth0Id( usuarioEmpleadoCreateDto.getAuth0Id() );
        usuarioEmpleado.userName( usuarioEmpleadoCreateDto.getUserName() );

        return usuarioEmpleado.build();
    }
}
