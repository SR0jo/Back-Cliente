package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dtos.ArticuloManufacturadoDetalleDTO;
import com.example.buensaborback.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDTO> {
    ArticuloManufacturadoDetalleDTO toDTO(ArticuloManufacturadoDetalle source);

    ArticuloManufacturadoDetalle toEntity(ArticuloManufacturadoDetalleDTO source);

    List<ArticuloManufacturadoDetalleDTO> toDTOsList(List<ArticuloManufacturadoDetalle> source);

    List<ArticuloManufacturadoDetalle> toEntitiesList(List<ArticuloManufacturadoDetalleDTO> source);
}