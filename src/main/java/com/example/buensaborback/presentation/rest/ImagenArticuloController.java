package com.example.buensaborback.presentation.rest;

import com.example.buensaborback.business.facade.impl.ImagenArticuloFacadeImpl;
import com.example.buensaborback.domain.dto.ImagenArticuloDto.ImagenArticuloCreateDto;
import com.example.buensaborback.domain.dto.ImagenArticuloDto.ImagenArticuloDto;
import com.example.buensaborback.domain.entities.ImagenArticulo;
import com.example.buensaborback.presentation.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/imagenArticulo")
public class ImagenArticuloController extends BaseControllerImpl<ImagenArticulo, ImagenArticuloDto, ImagenArticuloCreateDto, ImagenArticuloCreateDto, Long, ImagenArticuloFacadeImpl> {
    public ImagenArticuloController(ImagenArticuloFacadeImpl facade) {
        super(facade);
    }
}
