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
public enum TipoPerfil {
    PACIENTE(0), MEDICO(1), ADMINISTRADOR(2);
    
    private int codigo;
    
    private TipoPerfil(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public static TipoPerfil getPerfil(int codigo){
        //3 if e 1 else e retorna o valor do enum
        if(codigo == PACIENTE.getCodigo()){
        return PACIENTE;
        }
        if(codigo == MEDICO.getCodigo()){
        return MEDICO;
        }
        if(codigo == ADMINISTRADOR.getCodigo()){
        return ADMINISTRADOR;
        }
         throw new RuntimeException("Perfil inexistente");
    }
    
}
