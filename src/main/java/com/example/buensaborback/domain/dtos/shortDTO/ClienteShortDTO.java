package com.example.buensaborback.domain.dtos.shortDTO;

import com.example.buensaborback.domain.dtos.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteShortDTO extends BaseDTO {
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected LocalDate fechaNac;
}