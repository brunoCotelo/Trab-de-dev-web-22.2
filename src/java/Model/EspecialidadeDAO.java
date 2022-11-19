package Model;

 /* @author bruno
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.consulta_exame_descricao.Especialidade;


public class EspecialidadeDAO {

    public void Inserir(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO especialidade(descricao)"
                    + " VALUES (?)");
            sql.setString(1, especialidade.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Especialidade getEspecialidade(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Especialidade especialidade = new Especialidade();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM especialidade WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    especialidade.setDescricao(resultado.getString("descricao"));
                }
            }
            return especialidade;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE especialidade SET descricao = ? WHERE ID = ? ");
            sql.setString(1, especialidade.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM especialidade WHERE ID = ? ");
            sql.setInt(1, especialidade.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Especialidade> ListaDeEspecialidade() {
        System.out.println("Chamou a lista");
        ArrayList<Especialidade> minhasEspecialidades = new ArrayList();
        System.out.println("Criou a lista");
        Conexao conexao = new Conexao();
        try {
            System.out.println("Entrou no try");
            String selectSQL = "SELECT * FROM especialidade order by id";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                System.out.println("entrou no if do try");
                while (resultado.next()) {
                    System.out.println("entrou no while");
                    Especialidade especialidade = new Especialidade(
                        resultado.getString("descricao"));
                    minhasEspecialidades.add(especialidade);
                }
                System.out.println("saiu do while");
            }
        } catch (SQLException e) {
            System.out.println("Caiu no catch");
            throw new RuntimeException("Query de select (ListaDePacientes) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasEspecialidades;
    }

}
