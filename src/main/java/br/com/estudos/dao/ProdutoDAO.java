package br.com.estudos.dao;
import br.com.estudos.modelo.Categoria;
import br.com.estudos.modelo.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProdutoDAO {
    private Connection connection;
    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.execute();
            try(ResultSet rst = pstm.getGeneratedKeys()){
                while (rst.next()) produto.setId(rst.getInt(1));
            }
        }
    }
    public List<Produto> listar() throws SQLException{
        List<Produto> listaProdutos = new ArrayList<>();
        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2),
                            rst.getString(3));
                    listaProdutos.add(produto);
                }
            }
        }
        return listaProdutos;
    }
    public void remover() throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE ID > 2";
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            Integer produtosRemovidos = pstm.getUpdateCount();
            System.out.println( produtosRemovidos + ", foram removidos do banco");
        }
    }
    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setInt(1, ct.getId());
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2),
                            rst.getString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}
