/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Aplicacao.Atores.Usuario;

/**
 *
 * @author bruno
 */
public interface IUsuarioDAO {
    Usuario logar(String cpf, String senha);
}
