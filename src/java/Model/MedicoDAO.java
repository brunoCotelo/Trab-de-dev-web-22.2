/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Aplicacao.Atores.Medico;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class MedicoDAO {
        public void create (Medico med){
        Conexao conexao = new Conexao();
        PreparedStatement stmt = null;
        try{
            stmt =  conexao.getConexao().prepareStatement("INSERT INTO medico(nome, crm, estadocrm, cpf, senha, autorizado, idespecialidade) values(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, med.getNome());
            stmt.setInt(2, med.getCrm());
            stmt.setString(3, med.getEstadocrm());
            stmt.setString(4, med.getCpf());
            stmt.setString(5, med.getSenha());
            stmt.setString(6, med.getAutorizado());
            stmt.setString(7, med.getIdespecialidade());
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
