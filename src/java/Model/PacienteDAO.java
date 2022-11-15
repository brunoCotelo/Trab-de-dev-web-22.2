package Model;


/**
import Aplicacao.Atores.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


 *
 * @author bruno
 
public class PacienteDAO {
        public void create (Paciente pac){
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        try{
            stmt =  conexao.getConexao().prepareStatement("INSERT INTO paciente(nome, cpf, senha, autorizado, idtipopano) values(?, ?, ?, ?, ?)");
            stmt.setString(1, pac.getNome());
            stmt.setString(2, pac.getCpf());
            stmt.setString(3, pac.getSenha());
            stmt.setString(4, pac.getAutorizado());
            stmt.setString(5, pac.getIdtipoplano());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Falha em estabelecer conexao");
        }
                finally{
            conexao.closeConexao();
        }
    }
}*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.Atores.Paciente;


public class PacienteDAO {

    public void Inserir(Paciente paciente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("\"INSERT INTO paciente(nome, cpf, senha, autorizado, idtipopano)"
                    + " VALUES (?, ?, ?, ?, ?)");
            sql.setString(1, paciente.getNome());
            sql.setString(2, paciente.getCpf());
            sql.setString(3, paciente.getSenha());
            sql.setString(4, paciente.getAutorizado());
            sql.setInt(5, paciente.getIdtipoplano());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Paciente getPaciente(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Paciente paciente = new Paciente();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM pacientes WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    paciente.setNome(resultado.getString("nome"));
                    paciente.setCpf(resultado.getString("cpf"));
                    paciente.setSenha(resultado.getString("senha"));
                    paciente.setAutorizado(resultado.getString("autorizado"));
                    paciente.setIdtipoplano(resultado.getInt("idtipoplano"));
                }
            }
            return paciente;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Paciente paciente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE pacientes SET nome = ?, cpf = ?, senha = ?, autorizado = ?, idtipoplano = ? WHERE ID = ? ");
            sql.setString(1, paciente.getNome());
            sql.setString(2, paciente.getCpf());
            sql.setString(3, paciente.getSenha());
            sql.setString(4, paciente.getAutorizado());
            sql.setInt(5, paciente.getIdtipoplano());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Paciente paciente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM pacientes WHERE ID = ? ");
            sql.setInt(1, paciente.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Paciente> ListaDePacientes() {
        ArrayList<Paciente> meusPacientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM pacientes order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Paciente paciente = new Paciente(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("senha"),
                        resultado.getString("autorizado"),
                        resultado.getInt("idtipoplano"));
                        /**paciente.setId(Integer.parseInt(resultado.getString("id")));*/  //pode ter erro aqui no id
                    meusPacientes.add(paciente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDePacientes) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusPacientes;
    }

    public Paciente Logar(Paciente paciente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM pacientes WHERE cpf=? and senha =? LIMIT 1");
            sql.setString(1, paciente.getCpf());
            sql.setString(2, paciente.getSenha());
            ResultSet resultado = sql.executeQuery();
            Paciente pacienteObtido = new Paciente();
            if (resultado != null) {
                while (resultado.next()) {
                    pacienteObtido.setId(Integer.parseInt(resultado.getString("id")));
                    pacienteObtido.setNome(resultado.getString("nome"));
                    pacienteObtido.setCpf(resultado.getString("cpf"));
                    pacienteObtido.setSenha(resultado.getString("senha"));
                    pacienteObtido.setAutorizado(resultado.getString("autorizado"));
                    pacienteObtido.setIdtipoplano(resultado.getInt("idtipoplano"));
                }
            }
            return pacienteObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

}
