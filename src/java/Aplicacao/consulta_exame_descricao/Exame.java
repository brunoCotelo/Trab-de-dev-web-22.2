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
public class Exame {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtipoexame() {
        return idtipoexame;
    }

    public void setIdtipoexame(int idtipoexame) {
        this.idtipoexame = idtipoexame;
    }

    public int getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(int idconsulta) {
        this.idconsulta = idconsulta;
    }
    
    private int id;
    private int idtipoexame;
    private int idconsulta;
    
}
