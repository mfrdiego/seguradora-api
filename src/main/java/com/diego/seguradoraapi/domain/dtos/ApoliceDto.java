package com.diego.seguradoraapi.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ApoliceDto {

    @NotNull
    private long numeroApolice;

    @NotNull
    private LocalDate inicioVigencia;

    @NotNull
    private LocalDate fimVigencia;

    @NotBlank
    @Size(max = 7)
    private String placa;

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
}
