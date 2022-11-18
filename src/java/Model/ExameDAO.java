///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Model;
//
//import Aplicacao.consulta_exame_descricao.Exame;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// *
// * @author bruno
// */
//public class ExameDAO {
//        public void create (Exame exa){
//        Conexao conexao = new Conexao();
//        PreparedStatement stmt = null;
//        try{
//            stmt =  conexao.getConexao().prepareStatement("INSERT INTO exame(idtipoexame, idconsulta) values(?, ?)");
//            stmt.setString(1, exa.getIdtipoexame());
//            stmt.setString(2, exa.getIdconsulta());
//            stmt.executeUpdate();
//        }
//        catch(SQLException ex){
//            System.out.println("Falha em estabelecer conexao");
//        }
//                finally{
//            conexao.closeConexao();
//        }
//    }
//}
