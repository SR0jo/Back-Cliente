package com.example.buensaborback.domain.dto.ImagenPromocion;

import com.example.buensaborback.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImagenPromocionCreateDto extends BaseDto {
    private String url;
}
