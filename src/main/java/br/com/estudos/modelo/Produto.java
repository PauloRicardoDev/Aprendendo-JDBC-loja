package br.com.estudos.modelo;
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    public Produto() {
    }
    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    public Produto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Produto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    @Override
    public String toString() {
        return "Produto | " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", descricao: '" + descricao + '\'' +
                '|';
    }
}
