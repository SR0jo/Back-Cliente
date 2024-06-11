package com.example.buensaborback.presentation.rest;

import com.example.buensaborback.business.facade.impl.CategoriaFacadeImpl;
import com.example.buensaborback.business.mapper.ArticuloInsumoMapper;
import com.example.buensaborback.business.mapper.ArticuloManufacturadoMapper;
import com.example.buensaborback.business.mapper.CategoriaMapper;
import com.example.buensaborback.domain.dto.ArticuloInsumo.ArticuloInsumoDto;
import com.example.buensaborback.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaCreateDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaEditDto;
import com.example.buensaborback.domain.dto.Categoria.CategoriaShortDto;
import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.presentation.base.BaseControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaDto, CategoriaCreateDto, CategoriaEditDto, Long, CategoriaFacadeImpl> {
    @Autowired
    CategoriaMapper categoriaMapper;


    public CategoriaController(CategoriaFacadeImpl facade) {
        super(facade);
    }

    @GetMapping("/getInsumos/{idCategoria}{searchString}")
    public ResponseEntity<List<ArticuloInsumoDto>> getArticulos(@PathVariable Long idCategoria,@PathVariable String searchString,@PathVariable(required = false) Integer limit, @PathVariable(required = false) Long startId) {
        List<ArticuloInsumoDto> articuloInsumoDtos = facade.getInsumoSubCategoria(idCategoria,searchString);
        articuloInsumoDtos = articuloInsumoDtos.stream()
                .filter(a -> a.getId() > startId)
                .collect(Collectors.toList());
        if (articuloInsumoDtos.size() > limit) {
            articuloInsumoDtos = articuloInsumoDtos.subList(0, limit);
        }
        return ResponseEntity.ok(articuloInsumoDtos);
    }
    @GetMapping("/getManufacturados/{idCategoria}/{searchString}")
    public ResponseEntity<List<ArticuloManufacturadoDto>> getPorCategorias(@PathVariable Long idCategoria,@PathVariable String searchString,@PathVariable(required = false) Integer limit, @PathVariable(required = false) Long startId) {
        List<ArticuloManufacturadoDto> articuloManufacturadoDtos = facade.getManufacturadoSubCategoria(idCategoria,searchString);
        articuloManufacturadoDtos = articuloManufacturadoDtos.stream()
                .filter(a -> a.getId() > startId)
                .collect(Collectors.toList());
        if (articuloManufacturadoDtos.size() > limit) {
            articuloManufacturadoDtos = articuloManufacturadoDtos.subList(0, limit);
        }
        return ResponseEntity.ok(articuloManufacturadoDtos);
    }

    @GetMapping("/insumo")
    public ResponseEntity<List<CategoriaDto>> getCategoriasInsumo() {
        List<CategoriaDto> todasLasCategorias = facade.getAll();
        List<CategoriaDto> insumos = todasLasCategorias.stream()
                .filter(a -> a.isEsInsumo())
                .collect(Collectors.toList());
        return ResponseEntity.ok(insumos);
    }

    @GetMapping("/noInsumo")
    public ResponseEntity<List<CategoriaDto>> getCategoriasNoInsumo() {
        List<CategoriaDto> todasLasCategorias = facade.getAll();
        List<CategoriaDto> noInsumos = todasLasCategorias.stream()
                .filter(a -> !a.isEsInsumo())
                .collect(Collectors.toList());
        return ResponseEntity.ok(noInsumos);
    }

    @PutMapping("/addInsumo/{idCategoria}/{idInsumo}")
    public ResponseEntity<CategoriaDto> addArticuloInsumo(@PathVariable Long idCategoria, @PathVariable Long idInsumo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(facade.addInsumo(idCategoria, idInsumo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PutMapping("/addArticuloManufacturado/{idCategoria}/{idArticulo}")
    public ResponseEntity<CategoriaDto> addArticuloManufacturado(@PathVariable Long idCategoria, @PathVariable Long idArticulo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(facade.addManufacturado(idCategoria, idArticulo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/addSubCategoria/{idCategoria}")
    public ResponseEntity<CategoriaDto> addSubCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaCreateDto subCategoria) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(facade.addSubCategoria(idCategoria, subCategoria));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        facade.deleteById(id);
        try {
            facade.getById(id);
        }catch (Exception e){
            return ResponseEntity.ok("No se logro borrar la categoria por que posiblemente tiene articulos no borrados");
        }

        return ResponseEntity.ok("Se borro la categoria con exito");
    }

    @GetMapping("/getCategoriasSinArticulos/{limit}/{startId}")
    public ResponseEntity<List<CategoriaShortDto>> getCategoriasSinArticulos(@PathVariable(required = false) Integer limit, @PathVariable(required = false) Long startId) {
        if (limit == null || startId == null) {
            return ResponseEntity.badRequest().build();
        }
        List<CategoriaDto> categorias = facade.getAll();
        List<CategoriaShortDto> categoriasShort = new ArrayList<>();
        for (CategoriaDto categoria : categorias) {
            categoriasShort.add(categoriaMapper.dtoToShortDto(categoria));
        }
        categoriasShort = categoriasShort.stream()
                .filter(a -> a.getId() > startId)
                .collect(Collectors.toList());
        if (categoriasShort.size() > limit) {
            categoriasShort = categoriasShort.subList(0, limit);
        }
        return ResponseEntity.ok(categoriasShort);
    }


}
