package com.example.buensaborback.domain.dto.PromocionDetalle;

import com.example.buensaborback.domain.dto.Articulo.ArticuloDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoShortDto;
import com.example.buensaborback.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromocionDetalleCreateDto extends BaseDto {
    private ArticuloManufacturadoShortDto articuloManufacturado;
}
