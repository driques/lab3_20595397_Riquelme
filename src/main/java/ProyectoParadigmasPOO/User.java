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
  
    private final int idUser;
    private final String username;
    private final String password;
    private Date date; // fecha de registro
        /** 
        *
        * It is a constructor. 
        *
        * @param id  the id
        * @param userNameIn  the user name in
        * @param pass  the pass
        */
   
    public User (int id,String userNameIn,String pass){
        this.idUser = id;
        this.username = userNameIn;
        this.password = pass;
        this.date = new Date();
       
    
    }
        /** 
     *
     * Gets the identifier
     *
     * @return the identifier
     */

    // Getters
    public int getId(){
        return this.idUser;}
        /** 
     *
     * Gets the username
     *
     * @return the username
     */
    public String getUsername(){
        return this.username;}
        /** 
     *
     * Gets the password
     *
     * @return the password
     */
    public String getPassword(){
        return this.password;}
        /** 
     *
     * Gets the date
     *
     * @return the date
     */
    public Date getDate(){
        return this.date;}
    
    
   
}
