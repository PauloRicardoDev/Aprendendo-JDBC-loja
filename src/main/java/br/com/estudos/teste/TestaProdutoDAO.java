package br.com.estudos.teste;
import br.com.estudos.connection.ConnectionFactory;
import br.com.estudos.dao.ProdutoDAO;
import br.com.estudos.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class TestaProdutoDAO {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = new ConnectionFactory().bankConnection()){
            Produto produto = new Produto("MOUSE GAMER ASUS", "MOUSE GAMER RGB");
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(produto);
            List<Produto> lista = produtoDAO.listar();
            lista.forEach(System.out::println);
//            produtoDAO.remover();
//            lista.forEach(System.out::println);
        }
    }
}
