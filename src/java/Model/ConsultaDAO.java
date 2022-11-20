package Model;

/* @author bruno
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.consulta_exame_descricao.Consulta;
import java.sql.Connection;

public class ConsultaDAO {

    public void Inserir(Consulta consulta) throws Exception {
        Connection conexao = new Conexao().getConexao();
        try {
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO consulta(data, descricao, realizada, idmedico, idpaciente)"
                    + " VALUES (?, ?, ?, ?, ?)");

            sql.setString(1, consulta.getData());
            sql.setString(2, consulta.getDescricao());
            sql.setString(3, consulta.getRealizada());
            sql.setInt(4, consulta.getIdmedico());
            sql.setInt(5, consulta.getIdpaciente());
            sql.executeUpdate();
            sql.close();

        } catch (SQLException e) {
            System.out.println("catch DAO");
            throw new RuntimeException();
        } finally {
//            Conexao.closeConexao();
        }
    }

    public Consulta getConsulta(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Consulta consulta = new Consulta();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM consulta WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    consulta.setId(resultado.getInt("id"));
                    consulta.setData(resultado.getString("data"));
                    consulta.setDescricao(resultado.getString("descricao"));
                    consulta.setRealizada(resultado.getString("realizada"));
                    consulta.setIdmedico(resultado.getInt("idmedico"));
                    consulta.setIdpaciente(resultado.getInt("idpaciente"));
                }
            }
            return consulta;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Consulta consulta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE consulta SET data = ?, descricao = ?, realizada = ?, idmedico = ?, idpaciente = ? WHERE ID = ? ");
            sql.setString(1, consulta.getData());
            sql.setString(2, consulta.getDescricao());
            sql.setString(3, consulta.getRealizada());
            sql.setInt(4, consulta.getIdmedico());
            sql.setInt(5, consulta.getIdpaciente());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(int id) throws Exception {
         Connection conexao = new Conexao().getConexao();
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM consulta WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
//            conexao.closeConexao();
        }
    }

    public ArrayList<Consulta> ListaDeConsulta() {
        ArrayList<Consulta> minhasConsultas = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM consulta order by id";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Consulta consulta = new Consulta(
                            resultado.getString("data"),
                            resultado.getString("descricao"),
                            resultado.getString("realizada"),
                            resultado.getInt("idmedico"),
                            resultado.getInt("idpaciente"));
                    minhasConsultas.add(consulta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDePacientes) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasConsultas;
    }
    
    public ArrayList<Consulta> ListaDeConsultaPaciente(int idpaciente) {
        ArrayList<Consulta> consultas = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM consulta WHERE idpaciente=? order by data";
            PreparedStatement sql;
            sql = conexao.getConexao().prepareStatement(selectSQL);
            sql.setInt(1, idpaciente);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Consulta consulta = new Consulta(
                            resultado.getInt("id"),
                            resultado.getString("data"),
                            resultado.getString("descricao"),
                            resultado.getString("realizada"),
                            resultado.getInt("idmedico"),
                            resultado.getInt("idpaciente"));
                    consultas.add(consulta);
                }
            } 
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao consultar pacientes");
        } finally {
            conexao.closeConexao();
        }
        return consultas;
    }
    
    public ArrayList<Consulta> ListaDeConsultaMedico(int idmedico) {
        ArrayList<Consulta> consultas = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM consulta WHERE idmedico=? order by data";
            PreparedStatement sql;
            sql = conexao.getConexao().prepareStatement(selectSQL);
            sql.setInt(1, idmedico);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Consulta consulta = new Consulta(
                            resultado.getInt("id"),
                            resultado.getString("data"),
                            resultado.getString("descricao"),
                            resultado.getString("realizada"),
                            resultado.getInt("idmedico"),
                            resultado.getInt("idpaciente"));
                    consultas.add(consulta);
                }
            } 
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao consultar pacientes");
        } finally {
            conexao.closeConexao();
        }
        return consultas;
    }
    

}
