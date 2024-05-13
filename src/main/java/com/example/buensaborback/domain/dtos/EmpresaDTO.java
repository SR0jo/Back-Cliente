package com.example.buensaborback.domain.dtos;

import com.example.buensaborback.domain.entities.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaDTO extends BaseDTO {

    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<Sucursal> sucursales = new HashSet<>();
}