package com.diego.seguradoraapi.controller;


import com.diego.seguradoraapi.domain.dtos.ApoliceDto;
import com.diego.seguradoraapi.domain.model.ApoliceModel;
import com.diego.seguradoraapi.domain.service.ApoliceService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apolice")
public class ApoliceController {

    final ApoliceService apoliceService;

    public ApoliceController(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public ResponseEntity<Object> saveApolice(@RequestBody @Valid ApoliceDto apoliceDto){
        ApoliceModel apoliceModel = new ApoliceModel();
        BeanUtils.copyProperties(apoliceDto, apoliceModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.save(apoliceModel));
    }

    @GetMapping
    public ResponseEntity<List<ApoliceModel>> getAllApolice(){
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.findAll());
    }

    @GetMapping("/{numeroApolice}")
    public ResponseEntity<Object> getBuscarNumeroApolice(@PathVariable(value = "numeroApolice") long numeroApolice){
        Optional<ApoliceModel> apoliceModelOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Numero de Apolice não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(apoliceModelOptional.get());
    }

    @DeleteMapping("/{numeroApolice}")
    public ResponseEntity<Object> deleteApolice(@PathVariable(value = "numeroApolice") long numeroApolice){
        Optional<ApoliceModel> apoliceModelOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Numero de Apolice não encontrada.");
        }
        apoliceService.delete(apoliceModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Apolice deletada com sucesso");
    }

    @PutMapping("/{numeroApolice}")
    public ResponseEntity<Object> atualizarApolice(@PathVariable(value = "numeroApolice") long numeroApolice,
                                                   @RequestBody @Valid ApoliceDto apoliceDto) {
        Optional<ApoliceModel> apoliceModelOptional = apoliceService.findByNumeroApolice(numeroApolice);
        if (!apoliceModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apolice não encontrada");
        }
        ApoliceModel apoliceModel = apoliceModelOptional.get();
        apoliceModel.setInicioVigencia(apoliceDto.getInicioVigencia());
        apoliceModel.setFimVigencia(apoliceDto.getFimVigencia());
        apoliceModel.setPlaca(apoliceDto.getPlaca());
        return ResponseEntity.status(HttpStatus.OK).body(apoliceService.save(apoliceModel));
    }
}

