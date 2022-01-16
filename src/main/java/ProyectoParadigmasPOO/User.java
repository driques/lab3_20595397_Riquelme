/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author driques
 */
public class User {
    // Representación
    // idUser,username, password, fecha de registro
  
    private final int idUser;
    private final String username;
    private final String password;
    private Date date; // fecha de registro
   
    public User (int id,String userNameIn,String pass){
        this.idUser = id;
        this.username = userNameIn;
        this.password = pass;
        this.date = new Date();
       
    
    }

    // Getters
    public int getId(){
        return this.idUser;}
    public String getUsername(){
        return this.username;}
    public String getPassword(){
        return this.password;}
    public Date getDate(){
        return this.date;}
    
    
   /* public boolean isLogin(){
        null;
            }
    */
}
