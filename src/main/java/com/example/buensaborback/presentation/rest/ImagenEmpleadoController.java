package com.example.buensaborback.presentation.rest;

import com.example.buensaborback.business.facade.impl.ImagenEmpleadoFacadeImpl;
import com.example.buensaborback.domain.dto.ImagenEmpleado.ImagenEmpleadoCreateDto;
import com.example.buensaborback.domain.dto.ImagenEmpleado.ImagenEmpleadoDto;
import com.example.buensaborback.domain.entities.ImagenEmpleado;
import com.example.buensaborback.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/imagenEmpleado")
public class ImagenEmpleadoController extends BaseControllerImpl<ImagenEmpleado, ImagenEmpleadoDto, ImagenEmpleadoCreateDto, ImagenEmpleadoCreateDto, Long, ImagenEmpleadoFacadeImpl> {
    public ImagenEmpleadoController(ImagenEmpleadoFacadeImpl facade) {
        super(facade);
    }
}
