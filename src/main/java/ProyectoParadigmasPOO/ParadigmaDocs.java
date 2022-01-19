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
    private ArrayList<Document> docsVer;
        
    //Constructor
    /*Se crea una plataforma tipo ParadigmaDocs, donde se almacenar� el usuario
    activo, los registrados y sus documentos*/
    public ParadigmaDocs(){
        this.activeUser = null;
        this.users = new ArrayList<User>();
        this.docs = new ArrayList<Document>();
        this.docsVer = new ArrayList<Document>();
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
    public ArrayList<Document> getPlataformDocsVer(){
        return this.docsVer;
    }
    //Metodos
    /*Agrega un usuario a paradigmaDocs*/
    public void addUser(User userToAdd){
        this.users.add(userToAdd);
    }
    
    /*Agrega un documento a paradigmaDocs*/
    
    public void addDoc(Document docToAdd){
        this.docs.add(docToAdd);
    }
    
    public void addDoc(Document docToAdd, int index){
        this.docs.add(index, docToAdd);
    }
    
    
    public void removeDoc(Document docToRemove){
        this.docs.remove(docToRemove);
    
    }
    /*Agrega una version del doc a paradigmaDocs*/
    
    public void addDocVer(Document docToAdd){
        this.docsVer.add(docToAdd);
    }
    
    public void removeDocVer (Document docToRemove){
    
        this.docsVer.remove(docToRemove);
    }
    
    //Retorna si se esta registrado o no
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
    
    public int maxIdVer(int idDoc){
        int maxVer = 0;
        int lenVer = this.getPlataformDocsVer().size();
        
        for(int i = 0 ; i<lenVer ; i++){
            if (this.getPlataformDocsVer().get(i).getDocId()==idDoc+1){
                if (this.getPlataformDocsVer().get(i).getDocIdVer() > maxVer){
                    maxVer = this.getPlataformDocsVer().get(i).getDocIdVer() ;
                }    
            }

        }
        return maxVer;
        
    }
    
    public Document searchByIDVer(int idDoc, int idVer){
 
        int lenVersions = this.getPlataformDocsVer().size();
        for(int i = 0;i<lenVersions;i++){
           
            if (this.getPlataformDocsVer().get(i).getDocId()==idDoc+1 &&
            this.getPlataformDocsVer().get(i).getDocIdVer() == idVer){
                
                return this.getPlataformDocsVer().get(i); 
            
            }
        }
        //En caso erroneo
        Document elseDocument = this.getPlataformDocs().get(idDoc-1);
        
        return elseDocument;
    }
    
    public ArrayList<String> search(String user,String textToSearch){
        ArrayList<String> docFound = new ArrayList<>();
        
        int sizeDocs = this.docs.size();
        int sizeVerDocs = this.docsVer.size();
        
        for(int i = 0 ;i<sizeDocs; i++){
            if(this.docs.get(i).getDocOwner().equals(user)||this.docs.get(i).isShare(user)){
                if(this.docs.get(i).getDocContent().contains(textToSearch)){
                    String textToAdd = this.docs.get(i).getDocContent();
                    String idToAdd = String.valueOf(this.docs.get(i).getDocId());
                    String idVerToAdd = String.valueOf(this.docs.get(i).getDocIdVer());
                   
                    textToAdd = idToAdd+"<- ID doc\n"+idVerToAdd+"<- id version doc\n"+textToAdd+"\n";
                    docFound.add(textToAdd);
                    
                }
            
            }
        
        }
        //En versiones anteriores
        for(int i = 0 ;i<sizeVerDocs; i++){
            if(this.docsVer.get(i).getDocOwner().equals(user)||this.docsVer.get(i).isShare(user)){
                if(this.docsVer.get(i).getDocContent().contains(textToSearch)){
                    String textToAdd = this.docsVer.get(i).getDocContent();
                    String idToAdd = String.valueOf(this.docsVer.get(i).getDocId());
                    String idVerToAdd = String.valueOf(this.docsVer.get(i).getDocIdVer());
                   
                    textToAdd = idToAdd+")ID doc\n"+idVerToAdd+")id version doc\n"+textToAdd+"\n";
                    docFound.add(textToAdd);
                    
                }
            
            }
        
        }
        
        return docFound;
           
    
    }
    
    
   

}
