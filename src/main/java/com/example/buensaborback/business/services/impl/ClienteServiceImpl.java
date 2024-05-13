package com.example.buensaborback.business.services.impl;

import com.example.buensaborback.business.services.ClienteService;
import com.example.buensaborback.business.services.base.BaseServiceImpl;
import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.repositories.BaseRepository;
import com.example.buensaborback.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;

    }

}