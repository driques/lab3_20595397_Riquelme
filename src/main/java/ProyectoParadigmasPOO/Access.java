/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

/**
 *Clase Access representa los tipos de accesos que se les puede otorgar a un usuario
 * sobre un documento en especifico.  
 * @author driques
 */
public class Access {
    //Atributos
    String user;
    String access;
    /**
     * Constructor de Access, busca crear un objeto con los 
     * siguientes parametros
     * @param username para el username del usuario a otorgar acceso
     * @param accessDoc para el tipo de acceso
     */
    public Access(String username, String accessDoc){
        this.user = username;
        this.access = accessDoc;
    }
    
    //Getters
    /**
     * Getter para el usuario en cuestion.
     * @return el usuario.
     */
    public String getUserAccess(){
        return this.user;
                }
    /**
     * Getter para el acceso en cuestion.
     * @return el tipo de acceso.
     */
    public String getAccess(){
        return this.access;
    }
    
    
}
