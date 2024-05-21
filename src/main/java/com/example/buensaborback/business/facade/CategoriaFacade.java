package com.example.buensaborback.business.facade;

import com.example.buensaborback.business.facade.base.BaseFacade;
import com.example.buensaborback.domain.dto.Categoria.CategoriaCreateDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaDto;

public interface CategoriaFacade extends BaseFacade<CategoriaDto, CategoriaCreateDto, CategoriaCreateDto, Long> {
}