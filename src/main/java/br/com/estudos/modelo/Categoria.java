package br.com.estudos.modelo;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Produto> listprodutos = new ArrayList<Produto>();
    public Categoria() {
    }
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Integer getId() {
        return id;
    }
    public List<Produto> getListprodutos() {
        return listprodutos;
    }
    @Override
    public String toString() {
        return "Categoria|" +
                ", nome: '" + nome + '\'' +
                '|';
    }
    public void adicionar(Produto produto) {
        listprodutos.add(produto);
    }
}
