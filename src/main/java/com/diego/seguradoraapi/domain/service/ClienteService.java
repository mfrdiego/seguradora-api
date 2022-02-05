package com.diego.seguradoraapi.domain.service;

import com.diego.seguradoraapi.domain.exception.EntidadeNaoEncontradaException;
import com.diego.seguradoraapi.domain.model.Cliente;
import com.diego.seguradoraapi.domain.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    //GET
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }


    //GET
    public Cliente getCliente(long id){
        return findOrFail(id);
    }

    //POST
    public Cliente salvarCliente(Cliente c){
        c.getApolices().forEach(a -> a.setCliente(c));
        return clienteRepository.save(c);
    }
    //PUT
    public Cliente atualizarCliente(long id, Cliente c){
        Cliente clienteSalva = findOrFail(id);

        clienteSalva.getApolices().clear();

        clienteSalva.getApolices().addAll(c.getApolices());

        BeanUtils.copyProperties(c, clienteSalva,"id", "apolice");
        return clienteRepository.save(clienteSalva);
    }
    //DELETE
    public void deletarCliente(long id){
        Cliente c = findOrFail((id));
        clienteRepository.delete(c);
    }

    private  Cliente findOrFail(long id){
        return  clienteRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não localizada"));
    }
}
