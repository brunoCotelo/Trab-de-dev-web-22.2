/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Aplicacao.consulta_exame_descricao.Consulta;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ConsultaDAO {
        public void create (Consulta cons){
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        try{
            stmt =  conexao.getConexao().prepareStatement("INSERT INTO consulta(data, descricao, realizada, idmedico, idpaciente) values(?, ?, ?, ?, ?)");
            stmt.setDate(1, cons.getData());
            stmt.setString(2, cons.getDescricao());
            stmt.setString(3, cons.getRealizada());
            stmt.setString(4, cons.getIdmedico());
            stmt.setString(5, cons.getIdpaciente());
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
