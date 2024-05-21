package com.example.buensaborback.business.facade;

import com.example.buensaborback.business.facade.base.BaseFacade;
import com.example.buensaborback.domain.dto.Categoria.CategoriaCreateDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaEditDto;

public interface CategoriaFacade extends BaseFacade<CategoriaDto, CategoriaCreateDto, CategoriaEditDto, Long> {
    public CategoriaDto addInsumo(Long idCategoria, Long idInsumo);
    public CategoriaDto addManufacturado(Long idCategoria, Long idManufacturado);
    public CategoriaDto addSubCategoria(Long idCategoria, CategoriaCreateDto subCategoria);
}
