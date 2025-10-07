package connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static final String url = "jdbc:mysql://localhost:3306/gestao_tarefas";
    private static final String usuario = "root";
    private static final String senha = "root";
    private static Connection conexao;

    public static Connection get() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(url, usuario, senha);
            }
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
