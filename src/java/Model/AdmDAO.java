/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Aplicacao.Atores.Administrador;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author bruno
 */
public class AdmDAO {
    
    public void create (Administrador adm){
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        try{
            stmt =  conexao.getConexao().prepareStatement("INSERT INTO administrador(nome, cpf, senha) values(?, ?, ?)");
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getCpf());
            stmt.setString(3, adm.getSenha());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Falha em estabelecer conexao");
        }
        finally{
            conexao.closeConexao();
        }
    }
}
