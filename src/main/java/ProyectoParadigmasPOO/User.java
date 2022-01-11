/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;


import java.util.Date;

/**
 *
 * @author driques
 */
public class User {
    // Representación
    //  username, password, fecha de registro
  
    private String username;
    private String password;
    private Date date; // fecha de registro

    public User (String userNameIn,String pass){
       
        this.username = userNameIn;
        this.password = pass;
        this.date = new Date();
    
    }
    // Getters
    public String getUsername(){
        return this.username;}
    public String getPassword(){
        return this.password;}
    public Date getDate(){
        return this.date;}
    
    
}
