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
    // id, username, password, fecha de registro, lista de publicaciones, lista seguidos
    private int id;
    String username;
    private String password;
    private Date date; // fecha de registro

    /**
     *
     * @param ID
     * @param username
     * @param password
     */
    
    
    public User (int ID, String username,String password){
        this.id = ID;
        this.username = username;
        this.password = password;
        this.date = new Date();
    
    }
    // Selectores
    public int getID(){
        return this.id;}
    public String getUsername(){
        return this.username;}
    public String getPassword(){
        return this.password;}
    public Date getDate(){
        return this.date;}
    
        
        
    
}
