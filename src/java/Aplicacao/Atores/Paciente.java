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
public class Paciente {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Paciente(int id, String nome, String cpf, String senha, String autorizado, int idtipoplano) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.autorizado = autorizado;
        this.idtipoplano = idtipoplano;
    }

    public Paciente(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Paciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private String autorizado;
    private int idtipoplano;
}
