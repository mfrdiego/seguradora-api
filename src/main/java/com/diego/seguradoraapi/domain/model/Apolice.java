package com.diego.seguradoraapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false, length = 8)
    private String NumeroApolice;
    @NotBlank
    @Column(nullable = false, length = 8)
    private LocalDate InicioVigencia;
    @NotBlank
    @Column(nullable = false, length = 8)
    private LocalDate FimVigencia;
    @NotBlank
    @Column(nullable = false, length = 7)
    private String Placa;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroApolice() {
        return NumeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        NumeroApolice = numeroApolice;
    }

    public LocalDate getInicioVigencia() {
        return InicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        InicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return FimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        FimVigencia = fimVigencia;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
