/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools |  
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.ArrayList;
import java.util.Date;

/**
 *La clase documento, busca representar a este a traves de diversos atributos
 * juntos, los cuales conformarian lo requerido en el lab.
 * @author driques
 */
public class Document{
    //Representacion
    //creador, IDdoc, dateDoc,content,share,comment
    //Atributos
    private String owner;
    private int idDoc;
    private int idVer;
    private Date dateDoc;
    private String content;
    private String nameDoc;
    private ArrayList<Access> share;
    private ArrayList<Comment> commentList;
    
    
    //Constructor
    /**
     * Document, construye un objeto de tipo Document, y tiene lo siguientes
     * parametros de entrada
     * @param username para el username
     * @param id para el id del documento
     * @param nombreDoc para el nombre del documento
     * @param contenido para el contenido del documento
     */
    public Document(String username, int id,String nombreDoc,String contenido){
        this.owner = username;
        this.idDoc = id;
        this.idVer = 0;
        this.nameDoc = nombreDoc;
        this.dateDoc = new Date();
        this.content = contenido;
        this.share = new ArrayList<>();
        this.commentList = new ArrayList<>();
        }
    //Constructor copia
    /**
     * El siguiente constructor, tiene como utilidad copiar un objeto 
     * de tipo Document, para esta copia luego utilizarla y poder modificar
     * el Objeto sin que una version anterior se vea afectada.
     * @param copy como el documento a copiar.
     */
    public Document(Document copy){
        this.owner = copy.getDocOwner();
        this.idDoc = copy.getDocId();
        this.idVer = copy.getDocIdVer();
        this.nameDoc = copy.getDocName();
        this.dateDoc = copy.getDocDate();
        this.content = copy.getDocContent();
        this.share = copy.getDocShare();
        this.commentList = copy.getDocComment();
        }
    
    
    //Getters
    /**
     * Get para obtener el duenio del documento
     * 
     * @return el owner. 
     */
    public String getDocOwner(){
        return this.owner;   
    }
    /**
     * Get para obtener el nombre del documento.
     * @return el nombre del doc.
     */
     public String getDocName(){
        return this.nameDoc;   
    }
     /**
      * Get para el id del documento.
      * @return el id del documento.
      */
     
    public int getDocId(){
        return this.idDoc;   
    }
    
    /**
     * Get para obtener el id de la version del documento
     * @return el id de la version del documento. 
     */
    public int getDocIdVer(){
        return this.idVer;   
    }
    
    /**
     * Get para obtener el contenido del documento.
     * @return el contenido del documento.
     */
    public String getDocContent(){
        return this.content;
    }
    /**
     * Get para obtener la fecha del documento.
     * @return la fecha de creacion del documento.
     */
    public Date getDocDate(){
        return this.dateDoc;   
    }
    /**
     * Get para obtener la lista de usuarios compartidos
     * @return lista de objetos de tipo access.
     */
    public ArrayList<Access> getDocShare(){
        return this.share;   
    }
    /**
     * Get para obtener la lista de comentarios del documento.
     * @return lista de objetos de tipo Comment.
     */
    public ArrayList<Comment>getDocComment(){
        return this.commentList;
    
    }
    //Setters 
    /**
     * Settea un nuevo id para la version del documento.
     * @param newVer como la nueva version.
     */
    public void setIdVer(int newVer){
        this.idVer = newVer;
    }
    /**
     * Settea el nuevo contenido del documento.
     * @param newContent como el nuevo contenido.
     */
    public void setContent(String newContent){
        this.content = newContent;
    
    }
    //Métodos
    
    /**
     * Agrega un objeto de tipo Access a la lista de share.
     * @param addUser como el objeto a agregar.
     */
    public void addShare(Access addUser){
       this.share.add(addUser);
    }
    
    /**
     * Agrega un objeto de tipo Comment a la lista de comment.
     * @param comment como el objeto a agregar.
     */
    public void addComment (Comment comment){    
       this.commentList.add(comment);
    }
    /**
     * Crea una lista nueva y vacia sobre la lista de share para revocar accesos.
     */
    public void revokeAllAccess(){
        this.share = new ArrayList<>();
    }
    
    /**
     * idComment busca el id correlativo correspondiente para cada comentario.
     * @return el id.
     */    
    public int idComment(){
        if(this.commentList.size()!=0){
            return this.commentList.size();
        }else{
        return 0;
        }
    
    }
    /**isShare verifica que al usuario ingresado se le haya compartido
     * el documento en cualquiera de sus formas, es decir, comentario, lectura o escritura.
     * 
     * @param user.
     * @return booleano.
     */
    public boolean isShare(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)){
                return true;
            }
        }
            
        return false;
    }
    
    /**
     * isWritter verifica que el usuario tenga permisos de escritura
     * @param user
     * @return boolean
     */
    public boolean isWritter(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)&& share.get(i).getAccess().equals("escritura")){
                return true;
            }
        }
            
        return false;
    
    }
    
    /**
     * isReader verifica que el usuario tenga permisos de lectura
     * @param user
     * @return boolean
     */
    public boolean isReader(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)&& share.get(i).getAccess().equals("lectura")){
                return true;
            }
        }
            
        return false;
    
    }
    
    /**
     * isComment verifica que el usuario tenga permisos de comentario.
     * @param user
     * @return boolean
     */
    public boolean isComment(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)&& share.get(i).getAccess().equals("comentario")){
                return true;
            }
        }
            
        return false;
    
    }
    
}
        
   

