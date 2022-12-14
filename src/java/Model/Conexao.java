package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    /* Banco de dados: `dbjava` */
    public Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //load driver  
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/clinica", "root", ""); //pode ter erro no /dbjava
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel efetuar uma conexao com o BD!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Nao foi possivel encontrar a classe referente! Verifique o driver!");
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }

    public void closeConexao() {
        try {
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
