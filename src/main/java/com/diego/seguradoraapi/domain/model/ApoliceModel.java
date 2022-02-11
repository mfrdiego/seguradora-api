package com.diego.seguradoraapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Apolice {

    @Id
    @Column(nullable = false, length = 5)
    private long numeroApolice;

    @Column(nullable = false)
    private LocalDateTime inicioVigencia;

    @Column(nullable = false)
    private LocalDateTime fimVigencia;

    @Column(nullable = false, length = 7)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;


    public long getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(long numeroApolice) {
        numeroApolice = numeroApolice;
    }

    public LocalDateTime getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDateTime inicioVigencia) {
        inicioVigencia = inicioVigencia;
    }

    public LocalDateTime getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDateTime fimVigencia) {
        fimVigencia = fimVigencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
