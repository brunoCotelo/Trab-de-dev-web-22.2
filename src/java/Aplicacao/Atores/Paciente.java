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
public class Paciente extends Usuario {

    private static int perfil = 0;
    

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public int getIdtipoplano() {
        return idtipoplano;
    }

    public void setIdtipoplano(int idtipoplano) {
        this.idtipoplano = idtipoplano;
    }

    public Paciente(int id, String nome, String cpf, String senha, String autorizado, int idtipoplano) {
        super(id, nome, cpf, senha);
        this.autorizado = autorizado;
        this.idtipoplano = idtipoplano;
    }

    public Paciente(String cpf, String senha) {
        super(cpf, senha);
    }
    
    public Paciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    private String autorizado;
    private int idtipoplano;

    public int getPerfil() {
        return this.perfil;
    }
}
