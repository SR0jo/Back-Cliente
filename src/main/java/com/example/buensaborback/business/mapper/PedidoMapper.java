package com.example.buensaborback.business.mapper;

import com.example.buensaborback.business.facade.ClienteFacade;
import com.example.buensaborback.business.services.ClienteService;
import com.example.buensaborback.business.services.SucursalService;
import com.example.buensaborback.domain.dto.Pedido.PedidoCreateDto;
import com.example.buensaborback.domain.dto.Pedido.PedidoDto;
import com.example.buensaborback.domain.dto.Promocion.PromocionCreateDto;
import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.domain.entities.Promocion;
import com.example.buensaborback.repositories.ClienteRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {SucursalService.class,DomicilioMapper.class,DetallePedidoMapper.class, FacturaMapper.class})
public interface PedidoMapper extends BaseMapper<Pedido, PedidoDto, PedidoCreateDto, PedidoCreateDto> {

    @Mapping(target = "sucursal", source = "idSucursal", qualifiedByName = "getById")
    Pedido toEntityCreate(PedidoCreateDto source);

}
