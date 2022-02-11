package com.diego.seguradoraapi.domain.service;

import com.diego.seguradoraapi.domain.model.ClienteModel;
import com.diego.seguradoraapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }


    public boolean existsByCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findByCpf(String cpf) {
        return clienteRepository.findById(cpf);
    }

    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }
}
