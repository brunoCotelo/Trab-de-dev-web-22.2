/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Aplicacao.Atores.Paciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
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
}
