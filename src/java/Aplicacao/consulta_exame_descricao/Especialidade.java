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
public class Especialidade {

    public Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public Especialidade() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String especialidade) {
        this.descricao = especialidade;
    }
    
    private int id;
    private String descricao;
    
}   
