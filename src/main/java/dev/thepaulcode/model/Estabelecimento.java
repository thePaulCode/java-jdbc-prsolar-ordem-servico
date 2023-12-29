package dev.thepaulcode.model;

public class Estabelecimento {
    private Integer id;
    private String cpf_cnpj;
    private String nome;
    private Long celular;

    // Acessar atributos privados
    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpf_cnpj;
    }

    public void setCpfCnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", cpf_cnpj='" + cpf_cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", celular=" + celular +
                '}';
    }
}
