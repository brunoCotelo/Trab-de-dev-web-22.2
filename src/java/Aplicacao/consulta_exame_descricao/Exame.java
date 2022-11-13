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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdtipoexame() {
        return idtipoexame;
    }

    public void setIdtipoexame(String idtipoexame) {
        this.idtipoexame = idtipoexame;
    }

    public String getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(String idconsulta) {
        this.idconsulta = idconsulta;
    }
    
    private String id;
    private String idtipoexame;
    private String idconsulta;
    
}
