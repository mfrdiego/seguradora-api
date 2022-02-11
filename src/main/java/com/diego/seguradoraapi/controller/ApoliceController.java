package com.diego.seguradoraapi.controller;


import com.diego.seguradoraapi.domain.dtos.ApoliceDto;
import com.diego.seguradoraapi.domain.model.ApoliceModel;
import com.diego.seguradoraapi.domain.service.ApoliceService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


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
}

