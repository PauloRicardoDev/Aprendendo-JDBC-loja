package br.com.estudos.connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionFactory {
    public DataSource dataSource;
    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/LOJA_VIRTUAL");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("************");
        this.dataSource = comboPooledDataSource;
    }
    public Connection bankConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
