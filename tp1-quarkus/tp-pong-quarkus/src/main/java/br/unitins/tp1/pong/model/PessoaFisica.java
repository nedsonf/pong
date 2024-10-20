package br.unitins.tp1.faixas.model;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

    private String cpf;
    private Sexo sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

}
