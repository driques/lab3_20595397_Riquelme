/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

/**
 *
 * @author driques
 */
public class Access {
    //
    String user;
    String access;
    
    public Access(String username, String accessDoc){
        this.user = username;
        this.access = accessDoc;
    }
    
    //Getters
    
    
    public String getUserAccess(){
        return this.user;
                }
    
    public String getAccess(){
        return this.access;
    }
    
    
}
