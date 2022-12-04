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
   
    private int id;
    private String nome;
    private String cpf;
    private String senha;

    public Administrador(int id, String nome, String cpf, String senha) {
        super(nome, cpf, senha, TipoPerfil.ADMINISTRADOR);
        this.id = id;
    }

    public Administrador() {
        
    }

    public Administrador(String cpf, String senha) {
        super(cpf, senha);
    }
    
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

}
