package com.example.buensaborback.services;

import com.example.buensaborback.entities.Provincia;

public interface IProvinciaService extends IBaseService<Provincia,Long>{
    Provincia asignarPais(Long id, Long idPais);
}
