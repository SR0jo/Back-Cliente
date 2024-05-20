package com.example.buensaborback.domain.dto.Empleado;

import com.example.buensaborback.domain.dto.BaseDto;
import com.example.buensaborback.domain.entities.*;
import com.example.buensaborback.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.NotAudited;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoCreateDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


    private UsuarioEmpleado usuario;


    private ImagenEmpleado imagenPersona;


    private Set<Domicilio> domicilios = new HashSet<>();


    private Rol tipoEmpleado;


    private Set<Pedido> pedidos = new HashSet<>();


    private Sucursal sucursal;
}
