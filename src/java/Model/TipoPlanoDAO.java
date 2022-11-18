package Model;

 /* @author bruno
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.consulta_exame_descricao.TipoPlano;


public class TipoPlanoDAO {

    public void Inserir(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO tipoplano(descricao)"
                    + " VALUES (?)");
            sql.setString(1, tipoPlano.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public TipoPlano getTipoPlanoById(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            TipoPlano tipoPlano = new TipoPlano();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM tipoplano WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    tipoPlano.setDescricao(resultado.getString("descricao"));
                }
            }
            return tipoPlano;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE tipoplano SET descricao = ? WHERE ID = ? ");
            sql.setString(1, tipoPlano.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM tipoplano WHERE ID = ? ");
            sql.setInt(1, tipoPlano.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<TipoPlano> ListaDeTipoPlano() {
        ArrayList<TipoPlano> minhasTipoPlanos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM tipoplano order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    TipoPlano tipoPlano = new TipoPlano(
                        resultado.getString("descricao"));
                    minhasTipoPlanos.add(tipoPlano);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeTipoPlano) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasTipoPlanos;
    }

}
