package com.diego.seguradoraapi.controller;
;
import com.diego.seguradoraapi.domain.dtos.ClienteDto;
import com.diego.seguradoraapi.domain.model.ClienteModel;
import com.diego.seguradoraapi.domain.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto){
        //verificação antes de salvar se existe algum cpf
        if (clienteService.existsByCpf(clienteDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(("CPF em uso"));
        }
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }
    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllCliente(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getBuscaCpf(@PathVariable(value = "cpf") String cpf) {
        Optional<ClienteModel> clienteModelOptional = clienteService.findByCpf(cpf);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não localizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteCpf(@PathVariable(value = "cpf") String cpf) {
        Optional<ClienteModel> clienteModelOptional = clienteService.findByCpf(cpf);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não localizado");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
    }
}

