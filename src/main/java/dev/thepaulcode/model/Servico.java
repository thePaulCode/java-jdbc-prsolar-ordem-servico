package dev.thepaulcode.model;

public class Servico {

    private Integer id;
    private Double valor;
    private String descricao;

    // acessar atributos privados
    // JavaBeans
    // Getters and Setters
    // Atributos visiveis atravs de metodos

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
