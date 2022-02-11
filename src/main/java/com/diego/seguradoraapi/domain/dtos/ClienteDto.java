package com.diego.seguradoraapi.domain.dtos;

import com.danielfariati.annotation.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {

    @NotBlank
    @Size(max = 11)
    @CPF(required = true) // indica que dado é obrigatório
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
