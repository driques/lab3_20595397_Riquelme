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
    // idUser,username, password, fecha de registro
  
    private int idUser;
    private String username;
    private String password;
    private Date date; // fecha de registro

    public User (int id,String userNameIn,String pass){
        this.idUser = id;
        this.username = userNameIn;
        this.password = pass;
        this.date = new Date();
    
    }

    User(String driques, String password123) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Getters
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
