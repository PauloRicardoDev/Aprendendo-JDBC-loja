package br.com.PJDBC.teste;
import br.com.estudos.connection.ConnectionFactory;
import br.com.estudos.dao.CategoriaDAO;
import br.com.estudos.dao.ProdutoDAO;
import br.com.estudos.modelo.Categoria;
import br.com.estudos.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class TestaCategoriaDAO {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = new ConnectionFactory().bankConnection()){
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
            listaDeCategoria.stream().forEach(ct -> {
                System.out.println(ct.getNome());
                for (Produto produto : ct.getListprodutos()){
                    System.out.println(ct.getNome() + " - " + produto.getNome());
                }
            });
        }
    }
}
