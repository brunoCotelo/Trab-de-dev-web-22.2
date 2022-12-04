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
public class Medico extends Usuario {

    public Medico(String nome, int crm, String estadocrm, String cpf, String senha, String autorizado, int idespecialidade) {
        super(nome, cpf, senha, TipoPerfil.MEDICO);
        this.crm = crm;
        this.estadocrm = estadocrm;
        this.autorizado = autorizado;
        this.idespecialidade = idespecialidade;
    }

    public Medico() {
        
    }

    public Medico(int id, String nome, int crm, String estadocrm, String cpf, String senha, String autorizado, int idespecialidade) {
        super(nome, cpf, senha, TipoPerfil.MEDICO);
        this.id = id;
        this.crm = crm;
        this.estadocrm = estadocrm;
        this.autorizado = autorizado;
        this.idespecialidade = idespecialidade;
    }

    public Medico(String cpf, String senha) {
        super(cpf, senha);
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEstadocrm() {
        return estadocrm;
    }

    public void setEstadocrm(String estadocrm) {
        this.estadocrm = estadocrm;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public int getIdespecialidade() {
        return idespecialidade;
    }

    public void setIdespecialidade(int idespecialidade) {
        this.idespecialidade = idespecialidade;
    }
    
    private int id;
    private int crm;
    private String estadocrm;
    private String autorizado;
    private int idespecialidade;
}
