package com.diego.seguradoraapi.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class ApoliceModel {

    @Id
    @Column(nullable = false)
    private long numeroApolice;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicioVigencia;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fimVigencia;

    @Column(length = 7)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModel clienteModel;


    public long getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(long numeroApolice) {
        numeroApolice = numeroApolice;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        fimVigencia = fimVigencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        placa = placa;
    }

    public ClienteModel getCliente() {
        return clienteModel;
    }

    public void setCliente(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

}
