package Model;

 /* @author bruno
*/

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Aplicacao.Atores.Administrador;
import Aplicacao.Atores.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdmDAO {//implements IUsuarioDAO

    public void Inserir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO administrador(nome, cpf, senha)"
                    + " VALUES (?, ?, ?, ?, ?)");
            sql.setString(1, administrador.getNome());
            sql.setString(2, administrador.getCpf());
            sql.setString(3, administrador.getSenha());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador getAdministradorById(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Administrador administrador = new Administrador();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    administrador.setId(resultado.getInt("id"));
                    administrador.setNome(resultado.getString("nome"));
                    administrador.setCpf(resultado.getString("cpf"));
                    administrador.setSenha(resultado.getString("senha"));
                }
            }
            return administrador;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE administrador SET nome = ?, cpf = ?, senha = ? WHERE ID = ? ");
            sql.setString(1, administrador.getNome());
            sql.setString(2, administrador.getCpf());
            sql.setString(3, administrador.getSenha());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM administrador WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Administrador> ListaDeAdministradores() {
        ArrayList<Administrador> meusAdministradores = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM administrador order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador administrador = new Administrador(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cpf"),
                        resultado.getString("senha"));
                        /**administrador.setId(Integer.parseInt(resultado.getString("id")));*/  //pode ter erro aqui no id
                        meusAdministradores.add(administrador);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeAdministradores) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusAdministradores;
    }

    public Administrador Logar(String cpf, String senha) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE cpf = ? and senha = ? LIMIT 1");
            sql.setString(1, cpf);
            sql.setString(2, senha);
            ResultSet resultado = sql.executeQuery();
            Administrador administradorObtido = new Administrador();
            if (resultado != null) {
                while (resultado.next()) {
                    administradorObtido.setId(resultado.getInt("id"));
                    administradorObtido.setNome(resultado.getString("nome"));
                    administradorObtido.setCpf(resultado.getString("cpf"));
                    administradorObtido.setSenha(resultado.getString("senha"));
                }
            }
            return administradorObtido;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

//    @Override
//    public Usuario logar(String cpf, String senha) {
//        try {
//            return Logar(cpf, senha);
//        } catch (Exception ex) {
//            Logger.getLogger(AdmDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

}
