/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao.Atores;

/**
 *
 * @author bruno
 */
public class Administrador extends Usuario{
   

    public Administrador(int id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha, TipoPerfil.ADMINISTRADOR);
    }
    

    public Administrador() {
        
    }

    public Administrador(String cpf, String senha) {
        super(cpf, senha);
    }
    

}
