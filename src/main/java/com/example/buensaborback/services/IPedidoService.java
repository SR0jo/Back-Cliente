package com.example.buensaborback.services;

import com.example.buensaborback.entities.Pedido;


public interface IPedidoService extends IBaseService<Pedido,Long>{
    Pedido create(Pedido entity, Long domicilioId, Long sucursalId);
}
