package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.ArticuloInsumo.ArticuloInsumoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.example.buensaborback.domain.dto.Cliente.ClienteCreateDto;
import com.example.buensaborback.domain.dto.Cliente.ClienteDto;
import com.example.buensaborback.domain.dto.Cliente.ClienteEditDto;
import com.example.buensaborback.domain.dto.DetallePedido.DetallePedidoDto;
import com.example.buensaborback.domain.dto.Domicilio.DomicilioCreateDto;
import com.example.buensaborback.domain.dto.Domicilio.DomicilioDto;
import com.example.buensaborback.domain.dto.ImagenCliente.ImagenClienteDto;
import com.example.buensaborback.domain.dto.ImagenPromocion.ImagenPromocionDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoShortDto;
import com.example.buensaborback.domain.dto.Promocion.PromocionDto;
import com.example.buensaborback.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalShortDto;
import com.example.buensaborback.domain.dto.UsuarioCliente.UsuarioClienteCreateDto;
import com.example.buensaborback.domain.dto.UsuarioCliente.UsuarioClienteDto;
import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.domain.entities.DetallePedido;
import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.domain.entities.ImagenCliente;
import com.example.buensaborback.domain.entities.ImagenPromocion;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.domain.entities.Promocion;
import com.example.buensaborback.domain.entities.PromocionDetalle;
import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.domain.entities.UsuarioCliente;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T01:08:51-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Autowired
    private DomicilioMapper domicilioMapper;

    @Override
    public ClienteDto toDTO(Cliente source) {
        if ( source == null ) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            clienteDto.setEliminado( source.isEliminado() );
        }
        clienteDto.setNombre( source.getNombre() );
        clienteDto.setApellido( source.getApellido() );
        clienteDto.setTelefono( source.getTelefono() );
        clienteDto.setEmail( source.getEmail() );
        clienteDto.setUsuario( usuarioClienteToUsuarioClienteDto( source.getUsuario() ) );
        clienteDto.setImagenCliente( imagenClienteToImagenClienteDto( source.getImagenCliente() ) );
        clienteDto.setDomicilios( domicilioSetToDomicilioDtoSet( source.getDomicilios() ) );
        clienteDto.setPedidos( pedidoSetToPedidoShortDtoSet( source.getPedidos() ) );

        return clienteDto;
    }

    @Override
    public Cliente toEntity(ClienteDto source) {
        if ( source == null ) {
            return null;
        }

        Cliente.ClienteBuilder<?, ?> cliente = Cliente.builder();

        cliente.id( source.getId() );
        cliente.eliminado( source.isEliminado() );
        cliente.nombre( source.getNombre() );
        cliente.apellido( source.getApellido() );
        cliente.telefono( source.getTelefono() );
        cliente.email( source.getEmail() );
        cliente.usuario( usuarioClienteDtoToUsuarioCliente( source.getUsuario() ) );
        cliente.imagenCliente( imagenClienteDtoToImagenCliente( source.getImagenCliente() ) );
        cliente.domicilios( domicilioDtoSetToDomicilioSet( source.getDomicilios() ) );
        cliente.pedidos( pedidoShortDtoSetToPedidoSet( source.getPedidos() ) );

        return cliente.build();
    }

    @Override
    public Cliente toEntityCreate(ClienteCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Cliente.ClienteBuilder<?, ?> cliente = Cliente.builder();

        cliente.id( source.getId() );
        cliente.eliminado( source.isEliminado() );
        cliente.nombre( source.getNombre() );
        cliente.apellido( source.getApellido() );
        cliente.telefono( source.getTelefono() );
        cliente.email( source.getEmail() );
        cliente.usuario( usuarioClienteCreateDtoToUsuarioCliente( source.getUsuario() ) );
        cliente.domicilios( domicilioDtoSetToDomicilioSet( source.getDomicilios() ) );

        return cliente.build();
    }

    @Override
    public Cliente toUpdate(Cliente entity, ClienteEditDto source) {
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
                entity.setUsuario( UsuarioCliente.builder().build() );
            }
            usuarioClienteCreateDtoToUsuarioCliente1( source.getUsuario(), entity.getUsuario() );
        }
        else {
            entity.setUsuario( null );
        }
        if ( entity.getDomicilios() != null ) {
            Set<Domicilio> set = domicilioCreateDtoSetToDomicilioSet( source.getDomicilios() );
            if ( set != null ) {
                entity.getDomicilios().clear();
                entity.getDomicilios().addAll( set );
            }
            else {
                entity.setDomicilios( null );
            }
        }
        else {
            Set<Domicilio> set = domicilioCreateDtoSetToDomicilioSet( source.getDomicilios() );
            if ( set != null ) {
                entity.setDomicilios( set );
            }
        }

        return entity;
    }

    @Override
    public List<ClienteDto> toDTOsList(List<Cliente> source) {
        if ( source == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( source.size() );
        for ( Cliente cliente : source ) {
            list.add( toDTO( cliente ) );
        }

        return list;
    }

    protected UsuarioClienteDto usuarioClienteToUsuarioClienteDto(UsuarioCliente usuarioCliente) {
        if ( usuarioCliente == null ) {
            return null;
        }

        UsuarioClienteDto usuarioClienteDto = new UsuarioClienteDto();

        usuarioClienteDto.setId( usuarioCliente.getId() );
        if ( usuarioCliente.isEliminado() != null ) {
            usuarioClienteDto.setEliminado( usuarioCliente.isEliminado() );
        }
        usuarioClienteDto.setUserName( usuarioCliente.getUserName() );
        usuarioClienteDto.setAuth0Id( usuarioCliente.getAuth0Id() );
        usuarioClienteDto.setClave( usuarioCliente.getClave() );

        return usuarioClienteDto;
    }

    protected ImagenClienteDto imagenClienteToImagenClienteDto(ImagenCliente imagenCliente) {
        if ( imagenCliente == null ) {
            return null;
        }

        ImagenClienteDto imagenClienteDto = new ImagenClienteDto();

        imagenClienteDto.setName( imagenCliente.getName() );
        imagenClienteDto.setUrl( imagenCliente.getUrl() );

        return imagenClienteDto;
    }

    protected Set<DomicilioDto> domicilioSetToDomicilioDtoSet(Set<Domicilio> set) {
        if ( set == null ) {
            return null;
        }

        Set<DomicilioDto> set1 = new LinkedHashSet<DomicilioDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Domicilio domicilio : set ) {
            set1.add( domicilioMapper.toDTO( domicilio ) );
        }

        return set1;
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
        sucursalShortDto.setDomicilio( domicilioMapper.toDTO( sucursal.getDomicilio() ) );
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

    protected UsuarioCliente usuarioClienteDtoToUsuarioCliente(UsuarioClienteDto usuarioClienteDto) {
        if ( usuarioClienteDto == null ) {
            return null;
        }

        UsuarioCliente.UsuarioClienteBuilder usuarioCliente = UsuarioCliente.builder();

        usuarioCliente.auth0Id( usuarioClienteDto.getAuth0Id() );
        usuarioCliente.userName( usuarioClienteDto.getUserName() );
        usuarioCliente.clave( usuarioClienteDto.getClave() );

        return usuarioCliente.build();
    }

    protected ImagenCliente imagenClienteDtoToImagenCliente(ImagenClienteDto imagenClienteDto) {
        if ( imagenClienteDto == null ) {
            return null;
        }

        ImagenCliente.ImagenClienteBuilder<?, ?> imagenCliente = ImagenCliente.builder();

        imagenCliente.name( imagenClienteDto.getName() );
        imagenCliente.url( imagenClienteDto.getUrl() );

        return imagenCliente.build();
    }

    protected Set<Domicilio> domicilioDtoSetToDomicilioSet(Set<DomicilioDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Domicilio> set1 = new LinkedHashSet<Domicilio>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DomicilioDto domicilioDto : set ) {
            set1.add( domicilioMapper.toEntity( domicilioDto ) );
        }

        return set1;
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
        sucursal.domicilio( domicilioMapper.toEntity( sucursalShortDto.getDomicilio() ) );
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

    protected UsuarioCliente usuarioClienteCreateDtoToUsuarioCliente(UsuarioClienteCreateDto usuarioClienteCreateDto) {
        if ( usuarioClienteCreateDto == null ) {
            return null;
        }

        UsuarioCliente.UsuarioClienteBuilder usuarioCliente = UsuarioCliente.builder();

        usuarioCliente.auth0Id( usuarioClienteCreateDto.getAuth0Id() );
        usuarioCliente.userName( usuarioClienteCreateDto.getUserName() );
        usuarioCliente.clave( usuarioClienteCreateDto.getClave() );

        return usuarioCliente.build();
    }

    protected void usuarioClienteCreateDtoToUsuarioCliente1(UsuarioClienteCreateDto usuarioClienteCreateDto, UsuarioCliente mappingTarget) {
        if ( usuarioClienteCreateDto == null ) {
            return;
        }

        mappingTarget.setId( usuarioClienteCreateDto.getId() );
        mappingTarget.setEliminado( usuarioClienteCreateDto.isEliminado() );
        mappingTarget.setAuth0Id( usuarioClienteCreateDto.getAuth0Id() );
        mappingTarget.setUserName( usuarioClienteCreateDto.getUserName() );
        mappingTarget.setClave( usuarioClienteCreateDto.getClave() );
    }

    protected Set<Domicilio> domicilioCreateDtoSetToDomicilioSet(Set<DomicilioCreateDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Domicilio> set1 = new LinkedHashSet<Domicilio>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DomicilioCreateDto domicilioCreateDto : set ) {
            set1.add( domicilioMapper.toEntityCreate( domicilioCreateDto ) );
        }

        return set1;
    }
}
