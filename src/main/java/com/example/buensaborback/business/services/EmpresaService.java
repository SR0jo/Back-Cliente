package com.example.buensaborback.business.services;

import com.example.buensaborback.business.services.base.BaseService;
import com.example.buensaborback.domain.entities.Empresa;

public interface EmpresaService extends BaseService<Empresa, Long> {
    Empresa getEmpresaSucursales(Long idEmpresa);
}
