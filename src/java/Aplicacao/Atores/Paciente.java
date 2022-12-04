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


    public Paciente(String nome, String cpf, String senha, String autorizado, int idtipoplano) {
        super(nome, cpf, senha, TipoPerfil.PACIENTE);
        this.autorizado = autorizado;
        this.idtipoplano = idtipoplano;
    }
    
    
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

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Paciente(int id, String nome, String cpf, String senha, String autorizado, int idtipoplano) {
        super(nome, cpf, senha, TipoPerfil.PACIENTE);
        this.id = id;
        this.autorizado = autorizado;
        this.idtipoplano = idtipoplano;
    }

    public Paciente(String cpf, String senha) {
        super(cpf, senha);
    }
    
    public Paciente() {
    }
    
    private int id;
    private String autorizado;
    private int idtipoplano;

}
