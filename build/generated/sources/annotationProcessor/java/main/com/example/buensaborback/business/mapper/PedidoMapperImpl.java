package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.services.ClienteService;
import com.example.buensaborback.business.services.DomicilioService;
import com.example.buensaborback.business.services.SucursalService;
import com.example.buensaborback.domain.dto.Cliente.ClienteShortDto;
import com.example.buensaborback.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.example.buensaborback.domain.dto.DetallePedido.DetallePedidoDto;
import com.example.buensaborback.domain.dto.Empleado.EmpleadoDto;
import com.example.buensaborback.domain.dto.Empresa.EmpresaDto;
import com.example.buensaborback.domain.dto.ImagenEmpresa.ImagenEmpresaDto;
import com.example.buensaborback.domain.dto.ImagenSucursal.ImagenSucursalDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoCreateDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoShortDto;
import com.example.buensaborback.domain.dto.Sucursal.SucursalDto;
import com.example.buensaborback.domain.dto.UsuarioEmpleado.UsuarioEmpleadoDto;
import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.domain.entities.DetallePedido;
import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.domain.entities.Factura;
import com.example.buensaborback.domain.entities.ImagenEmpresa;
import com.example.buensaborback.domain.entities.ImagenSucursal;
import com.example.buensaborback.domain.entities.Pedido;
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
    date = "2024-06-18T20:34:26-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Autowired
    private SucursalService sucursalService;
    @Autowired
    private DomicilioMapper domicilioMapper;
    @Autowired
    private DetallePedidoMapper detallePedidoMapper;
    @Autowired
    private FacturaMapper facturaMapper;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private DomicilioService domicilioService;

    @Override
    public PedidoDto toDTO(Pedido source) {
        if ( source == null ) {
            return null;
        }

        PedidoDto pedidoDto = new PedidoDto();

        pedidoDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            pedidoDto.setEliminado( source.isEliminado() );
        }
        pedidoDto.setDetallesPedido( detallePedidoSetToDetallePedidoDtoSet( source.getDetallesPedido() ) );
        pedidoDto.setHoraEstimadaFinalizacion( source.getHoraEstimadaFinalizacion() );
        pedidoDto.setTotal( source.getTotal() );
        pedidoDto.setTotalCosto( source.getTotalCosto() );
        pedidoDto.setEstado( source.getEstado() );
        pedidoDto.setTipoEnvio( source.getTipoEnvio() );
        pedidoDto.setFormaPago( source.getFormaPago() );
        pedidoDto.setFechaPedido( source.getFechaPedido() );
        pedidoDto.setDomicilio( domicilioMapper.toDTO( source.getDomicilio() ) );
        pedidoDto.setCliente( clienteToClienteShortDto( source.getCliente() ) );
        pedidoDto.setSucursal( sucursalToSucursalDto( source.getSucursal() ) );
        pedidoDto.setEmpleado( empleadoToEmpleadoDto( source.getEmpleado() ) );
        pedidoDto.setFactura( facturaMapper.toDTO( source.getFactura() ) );

        return pedidoDto;
    }

    @Override
    public Pedido toEntity(PedidoDto source) {
        if ( source == null ) {
            return null;
        }

        Pedido.PedidoBuilder<?, ?> pedido = Pedido.builder();

        pedido.id( source.getId() );
        pedido.eliminado( source.isEliminado() );
        pedido.horaEstimadaFinalizacion( source.getHoraEstimadaFinalizacion() );
        pedido.total( source.getTotal() );
        pedido.totalCosto( source.getTotalCosto() );
        pedido.estado( source.getEstado() );
        pedido.tipoEnvio( source.getTipoEnvio() );
        pedido.formaPago( source.getFormaPago() );
        pedido.fechaPedido( source.getFechaPedido() );
        pedido.domicilio( domicilioMapper.toEntity( source.getDomicilio() ) );
        pedido.sucursal( sucursalDtoToSucursal( source.getSucursal() ) );
        pedido.factura( facturaMapper.toEntity( source.getFactura() ) );
        pedido.cliente( clienteShortDtoToCliente( source.getCliente() ) );
        pedido.detallesPedido( detallePedidoDtoSetToDetallePedidoSet( source.getDetallesPedido() ) );
        pedido.empleado( empleadoDtoToEmpleado( source.getEmpleado() ) );

        return pedido.build();
    }

    @Override
    public Pedido toUpdate(Pedido entity, PedidoCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setHoraEstimadaFinalizacion( source.getHoraEstimadaFinalizacion() );
        entity.setTotal( source.getTotal() );
        entity.setTotalCosto( source.getTotalCosto() );
        entity.setEstado( source.getEstado() );
        entity.setTipoEnvio( source.getTipoEnvio() );
        entity.setFormaPago( source.getFormaPago() );
        entity.setFechaPedido( source.getFechaPedido() );
        if ( source.getFactura() != null ) {
            if ( entity.getFactura() == null ) {
                entity.setFactura( Factura.builder().build() );
            }
            facturaMapper.toUpdate( entity.getFactura(), source.getFactura() );
        }
        else {
            entity.setFactura( null );
        }
        if ( entity.getDetallesPedido() != null ) {
            Set<DetallePedido> set = detallePedidoCreateDtoListToDetallePedidoSet( source.getDetallesPedido() );
            if ( set != null ) {
                entity.getDetallesPedido().clear();
                entity.getDetallesPedido().addAll( set );
            }
            else {
                entity.setDetallesPedido( null );
            }
        }
        else {
            Set<DetallePedido> set = detallePedidoCreateDtoListToDetallePedidoSet( source.getDetallesPedido() );
            if ( set != null ) {
                entity.setDetallesPedido( set );
            }
        }
        if ( source.getEmpleado() != null ) {
            if ( entity.getEmpleado() == null ) {
                entity.setEmpleado( Empleado.builder().build() );
            }
            empleadoDtoToEmpleado1( source.getEmpleado(), entity.getEmpleado() );
        }
        else {
            entity.setEmpleado( null );
        }

        return entity;
    }

    @Override
    public List<PedidoDto> toDTOsList(List<Pedido> source) {
        if ( source == null ) {
            return null;
        }

        List<PedidoDto> list = new ArrayList<PedidoDto>( source.size() );
        for ( Pedido pedido : source ) {
            list.add( toDTO( pedido ) );
        }

        return list;
    }

    @Override
    public Pedido toEntityCreate(PedidoCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Pedido.PedidoBuilder<?, ?> pedido = Pedido.builder();

        pedido.sucursal( sucursalService.getById( source.getIdSucursal() ) );
        pedido.cliente( clienteService.getById( source.getIdCliente() ) );
        pedido.domicilio( domicilioService.getById( source.getIdDomicilio() ) );
        pedido.id( source.getId() );
        pedido.eliminado( source.isEliminado() );
        pedido.horaEstimadaFinalizacion( source.getHoraEstimadaFinalizacion() );
        pedido.total( source.getTotal() );
        pedido.totalCosto( source.getTotalCosto() );
        pedido.estado( source.getEstado() );
        pedido.tipoEnvio( source.getTipoEnvio() );
        pedido.formaPago( source.getFormaPago() );
        pedido.fechaPedido( source.getFechaPedido() );
        pedido.factura( facturaMapper.toEntityCreate( source.getFactura() ) );
        pedido.detallesPedido( detallePedidoCreateDtoListToDetallePedidoSet( source.getDetallesPedido() ) );
        pedido.empleado( empleadoDtoToEmpleado( source.getEmpleado() ) );

        return pedido.build();
    }

    protected Set<DetallePedidoDto> detallePedidoSetToDetallePedidoDtoSet(Set<DetallePedido> set) {
        if ( set == null ) {
            return null;
        }

        Set<DetallePedidoDto> set1 = new LinkedHashSet<DetallePedidoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DetallePedido detallePedido : set ) {
            set1.add( detallePedidoMapper.toDTO( detallePedido ) );
        }

        return set1;
    }

    protected ClienteShortDto clienteToClienteShortDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteShortDto clienteShortDto = new ClienteShortDto();

        clienteShortDto.setId( cliente.getId() );
        if ( cliente.isEliminado() != null ) {
            clienteShortDto.setEliminado( cliente.isEliminado() );
        }
        clienteShortDto.setNombre( cliente.getNombre() );
        clienteShortDto.setApellido( cliente.getApellido() );
        clienteShortDto.setTelefono( cliente.getTelefono() );
        clienteShortDto.setEmail( cliente.getEmail() );

        return clienteShortDto;
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
        sucursalDto.setDomicilio( domicilioMapper.toDTO( sucursal.getDomicilio() ) );
        sucursalDto.setEmpresa( empresaToEmpresaDto( sucursal.getEmpresa() ) );
        sucursalDto.setImagenes( imagenSucursalSetToImagenSucursalDtoList( sucursal.getImagenes() ) );

        return sucursalDto;
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

    protected EmpleadoDto empleadoToEmpleadoDto(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId( empleado.getId() );
        if ( empleado.isEliminado() != null ) {
            empleadoDto.setEliminado( empleado.isEliminado() );
        }
        empleadoDto.setNombre( empleado.getNombre() );
        empleadoDto.setApellido( empleado.getApellido() );
        empleadoDto.setTelefono( empleado.getTelefono() );
        empleadoDto.setEmail( empleado.getEmail() );
        empleadoDto.setUsuario( usuarioEmpleadoToUsuarioEmpleadoDto( empleado.getUsuario() ) );
        empleadoDto.setTipoEmpleado( empleado.getTipoEmpleado() );
        empleadoDto.setPedidos( pedidoSetToPedidoShortDtoSet( empleado.getPedidos() ) );
        empleadoDto.setSucursal( sucursalToSucursalDto( empleado.getSucursal() ) );

        return empleadoDto;
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
        sucursal.domicilio( domicilioMapper.toEntity( sucursalDto.getDomicilio() ) );
        sucursal.empresa( empresaDtoToEmpresa( sucursalDto.getEmpresa() ) );
        sucursal.imagenes( imagenSucursalDtoListToImagenSucursalSet( sucursalDto.getImagenes() ) );

        return sucursal.build();
    }

    protected Cliente clienteShortDtoToCliente(ClienteShortDto clienteShortDto) {
        if ( clienteShortDto == null ) {
            return null;
        }

        Cliente.ClienteBuilder<?, ?> cliente = Cliente.builder();

        cliente.id( clienteShortDto.getId() );
        cliente.eliminado( clienteShortDto.isEliminado() );
        cliente.nombre( clienteShortDto.getNombre() );
        cliente.apellido( clienteShortDto.getApellido() );
        cliente.telefono( clienteShortDto.getTelefono() );
        cliente.email( clienteShortDto.getEmail() );

        return cliente.build();
    }

    protected Set<DetallePedido> detallePedidoDtoSetToDetallePedidoSet(Set<DetallePedidoDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<DetallePedido> set1 = new LinkedHashSet<DetallePedido>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DetallePedidoDto detallePedidoDto : set ) {
            set1.add( detallePedidoMapper.toEntity( detallePedidoDto ) );
        }

        return set1;
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

    protected Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto) {
        if ( empleadoDto == null ) {
            return null;
        }

        Empleado.EmpleadoBuilder<?, ?> empleado = Empleado.builder();

        empleado.id( empleadoDto.getId() );
        empleado.eliminado( empleadoDto.isEliminado() );
        empleado.nombre( empleadoDto.getNombre() );
        empleado.apellido( empleadoDto.getApellido() );
        empleado.telefono( empleadoDto.getTelefono() );
        empleado.email( empleadoDto.getEmail() );
        empleado.usuario( usuarioEmpleadoDtoToUsuarioEmpleado( empleadoDto.getUsuario() ) );
        empleado.tipoEmpleado( empleadoDto.getTipoEmpleado() );
        empleado.pedidos( pedidoShortDtoSetToPedidoSet( empleadoDto.getPedidos() ) );
        empleado.sucursal( sucursalDtoToSucursal( empleadoDto.getSucursal() ) );

        return empleado.build();
    }

    protected Set<DetallePedido> detallePedidoCreateDtoListToDetallePedidoSet(List<DetallePedidoCreateDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<DetallePedido> set = new LinkedHashSet<DetallePedido>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( DetallePedidoCreateDto detallePedidoCreateDto : list ) {
            set.add( detallePedidoMapper.toEntityCreate( detallePedidoCreateDto ) );
        }

        return set;
    }

    protected void usuarioEmpleadoDtoToUsuarioEmpleado1(UsuarioEmpleadoDto usuarioEmpleadoDto, UsuarioEmpleado mappingTarget) {
        if ( usuarioEmpleadoDto == null ) {
            return;
        }

        mappingTarget.setId( usuarioEmpleadoDto.getId() );
        mappingTarget.setEliminado( usuarioEmpleadoDto.isEliminado() );
        mappingTarget.setAuth0Id( usuarioEmpleadoDto.getAuth0Id() );
        mappingTarget.setUserName( usuarioEmpleadoDto.getUserName() );
    }

    protected void empresaDtoToEmpresa1(EmpresaDto empresaDto, Empresa mappingTarget) {
        if ( empresaDto == null ) {
            return;
        }

        mappingTarget.setId( empresaDto.getId() );
        mappingTarget.setEliminado( empresaDto.isEliminado() );
        mappingTarget.setNombre( empresaDto.getNombre() );
        mappingTarget.setRazonSocial( empresaDto.getRazonSocial() );
        mappingTarget.setCuil( empresaDto.getCuil() );
        if ( mappingTarget.getImagenes() != null ) {
            Set<ImagenEmpresa> set = imagenEmpresaDtoListToImagenEmpresaSet( empresaDto.getImagenes() );
            if ( set != null ) {
                mappingTarget.getImagenes().clear();
                mappingTarget.getImagenes().addAll( set );
            }
            else {
                mappingTarget.setImagenes( null );
            }
        }
        else {
            Set<ImagenEmpresa> set = imagenEmpresaDtoListToImagenEmpresaSet( empresaDto.getImagenes() );
            if ( set != null ) {
                mappingTarget.setImagenes( set );
            }
        }
    }

    protected void sucursalDtoToSucursal1(SucursalDto sucursalDto, Sucursal mappingTarget) {
        if ( sucursalDto == null ) {
            return;
        }

        mappingTarget.setId( sucursalDto.getId() );
        mappingTarget.setEliminado( sucursalDto.isEliminado() );
        mappingTarget.setNombre( sucursalDto.getNombre() );
        mappingTarget.setHorarioApertura( sucursalDto.getHorarioApertura() );
        mappingTarget.setHorarioCierre( sucursalDto.getHorarioCierre() );
        mappingTarget.setEsCasaMatriz( sucursalDto.getEsCasaMatriz() );
        mappingTarget.setDomicilio( domicilioMapper.toEntity( sucursalDto.getDomicilio() ) );
        if ( sucursalDto.getEmpresa() != null ) {
            if ( mappingTarget.getEmpresa() == null ) {
                mappingTarget.setEmpresa( Empresa.builder().build() );
            }
            empresaDtoToEmpresa1( sucursalDto.getEmpresa(), mappingTarget.getEmpresa() );
        }
        else {
            mappingTarget.setEmpresa( null );
        }
        if ( mappingTarget.getImagenes() != null ) {
            Set<ImagenSucursal> set = imagenSucursalDtoListToImagenSucursalSet( sucursalDto.getImagenes() );
            if ( set != null ) {
                mappingTarget.getImagenes().clear();
                mappingTarget.getImagenes().addAll( set );
            }
            else {
                mappingTarget.setImagenes( null );
            }
        }
        else {
            Set<ImagenSucursal> set = imagenSucursalDtoListToImagenSucursalSet( sucursalDto.getImagenes() );
            if ( set != null ) {
                mappingTarget.setImagenes( set );
            }
        }
    }

    protected void empleadoDtoToEmpleado1(EmpleadoDto empleadoDto, Empleado mappingTarget) {
        if ( empleadoDto == null ) {
            return;
        }

        mappingTarget.setId( empleadoDto.getId() );
        mappingTarget.setEliminado( empleadoDto.isEliminado() );
        mappingTarget.setNombre( empleadoDto.getNombre() );
        mappingTarget.setApellido( empleadoDto.getApellido() );
        mappingTarget.setTelefono( empleadoDto.getTelefono() );
        mappingTarget.setEmail( empleadoDto.getEmail() );
        if ( empleadoDto.getUsuario() != null ) {
            if ( mappingTarget.getUsuario() == null ) {
                mappingTarget.setUsuario( UsuarioEmpleado.builder().build() );
            }
            usuarioEmpleadoDtoToUsuarioEmpleado1( empleadoDto.getUsuario(), mappingTarget.getUsuario() );
        }
        else {
            mappingTarget.setUsuario( null );
        }
        mappingTarget.setTipoEmpleado( empleadoDto.getTipoEmpleado() );
        if ( mappingTarget.getPedidos() != null ) {
            Set<Pedido> set = pedidoShortDtoSetToPedidoSet( empleadoDto.getPedidos() );
            if ( set != null ) {
                mappingTarget.getPedidos().clear();
                mappingTarget.getPedidos().addAll( set );
            }
            else {
                mappingTarget.setPedidos( null );
            }
        }
        else {
            Set<Pedido> set = pedidoShortDtoSetToPedidoSet( empleadoDto.getPedidos() );
            if ( set != null ) {
                mappingTarget.setPedidos( set );
            }
        }
        if ( empleadoDto.getSucursal() != null ) {
            if ( mappingTarget.getSucursal() == null ) {
                mappingTarget.setSucursal( Sucursal.builder().build() );
            }
            sucursalDtoToSucursal1( empleadoDto.getSucursal(), mappingTarget.getSucursal() );
        }
        else {
            mappingTarget.setSucursal( null );
        }
    }
}
