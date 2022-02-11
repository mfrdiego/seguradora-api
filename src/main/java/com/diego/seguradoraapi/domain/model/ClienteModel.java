package com.diego.seguradoraapi.domain.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.danielfariati.annotation.CPF;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "cliente")

public class ClienteModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @CPF(required = true) // indica que dado é obrigatório
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 100)
    private String cidade;


    @Valid
    @JsonIgnoreProperties("cliente")
    @OneToMany(mappedBy = "clienteModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApoliceModel> apoliceModels = new ArrayList<>();




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<ApoliceModel> getApolices() {
        return apoliceModels;
    }

    public void setApolices(List<ApoliceModel> apoliceModels) {
        this.apoliceModels = apoliceModels;
    }

}
