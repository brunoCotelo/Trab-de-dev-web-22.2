/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao.consulta_exame_descricao;

/**
 *
 * @author bruno
 */
public class Consulta {

    public Consulta(String data, String descricao, String realizada, int idmedico, int idpaciente) {
        this.data = data;
        this.descricao = descricao;
        this.realizada = realizada;
        this.idmedico = idmedico;
        this.idpaciente = idpaciente;
    }

    public Consulta() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRealizada() {
        return realizada;
    }

    public void setRealizada(String realizada) {
        this.realizada = realizada;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }
    
    private int id;
    private String data;
    private String descricao;
    private String realizada;
    private int idmedico;
    private int idpaciente;
    
}
