/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;



import java.util.Date;

/**
 *User va a representar a un usuario, con su id, username y contrasenia.
 * @author driques
 */
public class User {
    // Representación
    // idUser,username, password, fecha de registro
    //Atributos
    private final int idUser;
    private final String username;
    private final String password;
    private Date date; // fecha de registro
        /** 
        *
        * Este es el constructor, crea un usuario recibiendo su if, su username y su password.
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
     * Get al id.
     *
     * @return the identifier
     */

    // Getters
    public int getId(){
        return this.idUser;}
        /** 
     *
     * Get al nombre de usuario.
     *
     * @return the username
     */
    public String getUsername(){
        return this.username;}
        /** 
     *
     * Get a la password.
     *
     * @return the password
     */
    public String getPassword(){
        return this.password;}
        /** 
     *
     * Get a la fecha.
     *
     * @return the date
     */
    public Date getDate(){
        return this.date;}
    
    
   
}
