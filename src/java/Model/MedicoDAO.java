package Model;

 /* @author bruno
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.Atores.Medico;


public class MedicoDAO {

    public void Inserir(Medico medico) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("\"INSERT INTO medico(nome, crm, estadocrm, cpf, senha, autorizado, idespecialidade)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)");
            sql.setString(1, medico.getNome());
            sql.setInt(2, medico.getCrm());
            sql.setString(3, medico.getEstadocrm());
            sql.setString(4, medico.getCpf());
            sql.setString(5, medico.getSenha());
            sql.setString(6, medico.getAutorizado());
            sql.setInt(7, medico.getIdespecialidade());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Medico getMedicoById(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Medico medico = new Medico();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM medico WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    medico.setId(resultado.getInt("id"));
                    medico.setNome(resultado.getString("nome"));
                    medico.setCrm(resultado.getInt("crm"));
                    medico.setEstadocrm(resultado.getString("estadocrm"));
                    medico.setCpf(resultado.getString("cpf"));
                    medico.setSenha(resultado.getString("senha"));
                    medico.setAutorizado(resultado.getString("autorizado"));
                    medico.setIdespecialidade(resultado.getInt("idespecialidade"));
                }
            }
            return medico;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Medico medico) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE medico SET nome = ?, crm = ?, estadocrm = ?, cpf = ?, senha = ?, autorizado = ?, idespecialidade = ?  WHERE ID = ? ");
            sql.setString(1, medico.getNome());
            sql.setInt(2, medico.getCrm());
            sql.setString(3, medico.getEstadocrm());
            sql.setString(4, medico.getCpf());
            sql.setString(5, medico.getSenha());
            sql.setString(6, medico.getAutorizado());
            sql.setInt(7, medico.getIdespecialidade());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Medico medico) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM medico WHERE ID = ? ");
            sql.setInt(1, medico.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Medico> ListaDeMedicos() {
        ArrayList<Medico> meusMedicos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM medico order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Medico medico = new Medico(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getInt("crm"),
                        resultado.getString("estadocrm"),
                        resultado.getString("cpf"),
                        resultado.getString("senha"),
                        resultado.getString("autorizado"),
                        resultado.getInt("idespecialidade"));
                    meusMedicos.add(medico);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeMedicos) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusMedicos;
    }

    public Medico Logar(Medico medico) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM medico WHERE cpf = ? and senha = ? LIMIT 1");
            sql.setString(1, medico.getCpf());
            sql.setString(2, medico.getSenha());
            ResultSet resultado = sql.executeQuery();
            Medico medicoObtido = new Medico();
            if (resultado != null) {
                while (resultado.next()) {
                    medicoObtido.setId(resultado.getInt("id"));
                    //medicoObtido.setId(Integer.parseInt(resultado.getString("id")));
                    medicoObtido.setNome(resultado.getString("nome"));
                    medicoObtido.setCrm(resultado.getInt("crm"));
                    medicoObtido.setEstadocrm(resultado.getString("estadocrm"));
                    medicoObtido.setCpf(resultado.getString("cpf"));
                    medicoObtido.setSenha(resultado.getString("senha"));
                    medicoObtido.setAutorizado(resultado.getString("autorizado"));
                    medicoObtido.setIdespecialidade(resultado.getInt("idespecialidade"));
                }
            }
            return medicoObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

}
