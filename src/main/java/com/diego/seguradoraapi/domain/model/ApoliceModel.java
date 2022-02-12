package com.diego.seguradoraapi.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class ApoliceModel {

    @Id
    @Column(nullable = false, length = 5)
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
        this.numeroApolice = numeroApolice;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}
