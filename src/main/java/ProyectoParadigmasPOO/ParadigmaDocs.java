/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.ArrayList;

/**
 *La clase ParadigmaDocs busca representar toda la plataforma donde se debe almacenar
 * el editor de textos.
 * @author driques
 */
public class ParadigmaDocs {
    //Atributos
    private String activeUser;
    private ArrayList<User> users;  
    private ArrayList<Document> docs;
    private ArrayList<Document> docsVer;
        
    //Constructor
    /*Se crea una plataforma tipo ParadigmaDocs, donde se almacenarï¿½ el usuario
    activo, los registrados y sus documentos*/
    /***Se crea una plataforma tipo ParadigmaDocs, donde se almacenara el usuario
     * activo, los registrados y sus documentos (activos y versiones anteriores)
     * 
     */
    public ParadigmaDocs(){
        this.activeUser = null;
        this.users = new ArrayList<User>();
        this.docs = new ArrayList<Document>();
        this.docsVer = new ArrayList<Document>();
    }
    //Getters
    /**
     * Get el usuario activo.
     * @return el usuario activo.
     */
    public String getActiveUser(){
        return this.activeUser;
    }
    /**
     * Get los usuarios registrados.
     * @return usuarios registrados.
     */
    public ArrayList<User> getRegisterUsers(){
        return this.users;
    }
    /**
     * Get los documentos alojados en la plataforma.
     * @return los documentos.
     */
    public ArrayList<Document> getPlatformDocs(){
        return this.docs;
    }
    /**
     * Get las versiones anteriores de los documentos alojados en la plataforma.
     * @return versiones de documentos.
     */
    public ArrayList<Document> getPlatformDocsVer(){
        return this.docsVer;
    }
    //Metodos
    
    /**
     * Agrega un usuario a paradigmaDocs
     * @param userToAdd como el usuario a agregar
     */
    
    public void addUser(User userToAdd){
        this.users.add(userToAdd);
    }
    
    
    
    /**
     *Agrega un documento a paradigmaDocs 
     * @param docToAdd como el documento a agregar
     */
    
    public void addDoc(Document docToAdd){
        this.docs.add(docToAdd);
    }
    /**
     * Se utiliza sobrecarga para poder indicar un indce especifico al método anterior.
     * @param docToAdd como el doc a agregar.
     * @param index como el indice.
     */
    public void addDoc(Document docToAdd, int index){
        this.docs.add(index, docToAdd);
    }
    
    /**
     * RemoveDoc nos permite reomver un documento en especifico de la lista de documentos.
     * @param docToRemove como el documento a remover.
     */
    public void removeDoc(Document docToRemove){
        this.docs.remove(docToRemove);
    
    }
    
    
    
    /**
     *Agrega una version del doc a paradigmaDocs .
     * @param docToAdd como el documento a agregar a las versiones.
     */
    public void addDocVer(Document docToAdd){
        this.docsVer.add(docToAdd);
    }
    /**
     * removeDocVer nos permite remover un documento en especifico de la lista de versiones.
     * @param docToRemove como el documento a remover.
     */
    public void removeDocVer (Document docToRemove){
    
        this.docsVer.remove(docToRemove);
    }
    
    
    /**
     * Retorna si se esta registrado o no.
     * @param username como el usuario a revisar.
     * @return booleano.
     */
   
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
    
    
    /**
     *Inicia el usuario activo en la plataforma.
     * @param userActive como el usuario a dejar activo
     */
    
    public void AddActiveUser(String userActive){
        this.activeUser = userActive;
    }
    /**
     * Realiza el logout de la plataforma.
     */
    public void logout(){
        this.activeUser = null;
    }
    /**
     * Nos permite registrar un usuario en la platforma.
     * @param username como el usuario a registrar.
     * @param password como la contrasenia del user.
     * @return boolean para verificar si se registro o no.
     */
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
    /**
     * Nos permite iniciar sesion dentro de la plataforma.
     * @param username como nombre del usuario.
     * @param password como la contrasenia.
     * @return boolean, dependiendo si es que se pudo iniciar sesion o no.
     */
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
     /**
     * Nos permite crear un nuevo documento
     * @param nombreDoc como el nombre del documento.
     * @param content como el contenido del documento.
     */
    public void create(String nombreDoc, String content){
        int tamanioDocs = this.getPlatformDocs().size();
        Document createDoc = new Document(this.getActiveUser(),tamanioDocs+1,nombreDoc,content);
        this.addDoc(createDoc);
    }
    
    
    
    /**
     * Nos permite saber el id max de las versiones de un documento en especifico.
     * @param idDoc como el id del documento a revisar.
     * @return int del id mas grande.
     */
    public int maxIdVer(int idDoc){
        int maxVer = 0;
        int lenVer = this.getPlatformDocsVer().size();
        
        for(int i = 0 ; i<lenVer ; i++){
            if (this.getPlatformDocsVer().get(i).getDocId()==idDoc+1){
                if (this.getPlatformDocsVer().get(i).getDocIdVer() > maxVer){
                    maxVer = this.getPlatformDocsVer().get(i).getDocIdVer() ;
                }    
            }

        }
        return maxVer;
        
    }
    /**
     * Nos permite buscar un documento en especifico a traves del id de la version de este.
     * @param idDoc como el id del documento.
     * @param idVer como el id de la version del documento.
     * @return Document encontrado.
     */
    public Document searchByIDVer(int idDoc, int idVer){
 
        int lenVersions = this.getPlatformDocsVer().size();
        for(int i = 0;i<lenVersions;i++){
           
            if (this.getPlatformDocsVer().get(i).getDocId()==idDoc+1 &&
            this.getPlatformDocsVer().get(i).getDocIdVer() == idVer){
                
                return this.getPlatformDocsVer().get(i); 
            
            }
        }
        //En caso erroneo
        Document elseDocument = this.getPlatformDocs().get(idDoc-1);
        
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
    
    /**
     * Nos permite reemplazar texto especifico sobre un documento.
     * @param idText como el id del documento a reemplazar texto.
     * @param textToSearch como el texto a buscar.
     * @param textToReplace como el texto a reemplazar.
     * @return boolean dependiendo si se pudo aplicar o no el metodo.
     */
    public boolean searchAndReplace(int idText ,String textToSearch, String textToReplace){
        if(this.docs.get(idText).getDocContent().contains(textToSearch)){
                    String textReplace = this.docs.get(idText).getDocContent();
                    String newText = textReplace.replaceAll(textToSearch, textToReplace);
                    Document docVer = new Document(this.docs.get(idText));
                    this.docs.get(idText).setContent(newText);
                    this.docs.get(idText).setIdVer(this.docs.get(idText).getDocIdVer()+1);
                    this.addDocVer(docVer);
                    return true;
                }
        else{
           return false;
        }
    
    }
    /**
     * Nos permite comentar un documento especifico.
     * @param idDoc como el id del documento.
     * @param textToComment como el texto a comentar.
     */
    public void comment(int idDoc,String textToComment){
        int idComment = this.docs.get(idDoc).idComment();
        String ownerComment = this.getActiveUser();
        Comment newComment = new Comment(idComment,ownerComment,textToComment,this.docs.get(idDoc));
        this.docs.get(idDoc).addComment(newComment);
        
       
    }

}
