package com.example.buensaborback.presentation.rest;

import com.example.buensaborback.business.facade.impl.UsuarioClienteFacadeImpl;
import com.example.buensaborback.domain.dtos.UsuarioClienteDTO;
import com.example.buensaborback.domain.entities.UsuarioCliente;
import com.example.buensaborback.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/usuarioCliente")
public class UsuarioClienteController extends BaseControllerImpl<UsuarioCliente, UsuarioClienteDTO, Long, UsuarioClienteFacadeImpl> {
    public UsuarioClienteController(UsuarioClienteFacadeImpl facade) {
        super(facade);
    }
}