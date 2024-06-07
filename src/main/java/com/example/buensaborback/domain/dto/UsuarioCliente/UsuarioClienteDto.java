package com.example.buensaborback.domain.dto.UsuarioCliente;

import com.example.buensaborback.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
public class UsuarioClienteDto extends BaseDto {
    private String userName;
    private String auth0Id;
    private String clave;
}
