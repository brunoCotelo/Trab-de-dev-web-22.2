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

    private static int perfil = 1;
    

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

    private String nome;
    private int crm;
    private String estadocrm;
    private String cpf;
    private String senha;
    private String autorizado;
    private int idespecialidade;
}
