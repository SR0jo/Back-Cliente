package com.example.buensaborback.services;

import com.example.buensaborback.entities.Domicilio;

public interface IDomicilioService extends IBaseService<Domicilio,Long>{
    Domicilio asignarLocalidad(Long id, Long idLocalidad);
}
