package com.example.buensaborback.domain.dto.Articulo;

import com.example.buensaborback.domain.dto.BaseDto;
import com.example.buensaborback.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloCreateDto extends BaseDto {
    private String denominacion;
    private Double precioVenta;
    //protected Set<ImagenArticuloDto> imagenes = new HashSet<>();
    private UnidadMedidaCreateDto unidadMedida;
    private Long idCategoria;
}