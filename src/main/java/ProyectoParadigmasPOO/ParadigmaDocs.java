/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.ArrayList;

/**
 *
 * @author driques
 */
public class ParadigmaDocs {
    private String activeUser;
    private ArrayList<User> users;  
    private ArrayList<Document> docs;
    
    
    //Constructor
    /*Se crea una plataforma tipo ParadigmaDocs, donde se almacenar� el usuario
    activo, los registrados y sus documentos*/
    public ParadigmaDocs(){
        this.activeUser = null;
        this.users = new ArrayList<User>();
        this.docs = new ArrayList<Document>();
    }
    //Selectores
    public String getActiveUser(){
        return this.activeUser;
    }
    public ArrayList<User> getRegisterUsers(){
        return this.users;
    }
    
    public ArrayList<Document> getPlataformDocs(){
        return this.docs;
    }
    //Metodos
    /*Agrega un usuario a paradigmaDocs*/
    public void addUser(User userToAdd){
        this.users.add(userToAdd);
    }
    
    /*Agrega un documento a paradigmaDocs*/
    
    public void addDoc(Document docToAdd ){
        this.docs.add(docToAdd);
    }
    public boolean isRegister(String username){
        if(this.users.isEmpty()){
            return false;
        }
        else{
            for(int i = 0;i<this.users.size();i++){
                if((this.users.get(i).getUsername()).equals(username)){
                    return true;
                }
            }
            return false;    
        }    
    }
    //Inicia el usuario activo en la plataforma, o hace un logout
    public void AddActiveUser(String userActive){
        this.activeUser = userActive;
    }
    //LogOut
    public void logout(){
        this.activeUser = null;
    }
    
    public boolean register(String username, String password){
        if(users.isEmpty()){
            User newUser = new User(0,username,password);
            this.users.add(newUser);         
            //Se registra
            return true;
        }
        else if (!isRegister(username)){
            //Se registra
            int cantidadUsrs = this.users.size();
            User newUser = new User(cantidadUsrs+1,username,password);
            this.users.add(newUser);         
            return true;
        }
        else{
            return false;
        }
    }
    public boolean login (String username, String password){
        if(users.isEmpty()){
            return false;
        }else{
            int lenUsers = this.users.size();
            for(int i = 0 ; i<lenUsers;i++){
                if((users.get(i).getUsername().equals(username)) && (users.get(i).getPassword().equals(password))){
                    this.activeUser = username;
                    return true;
                }
            
            }
            return false;
        }
        
        
    }

}
