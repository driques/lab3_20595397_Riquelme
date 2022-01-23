/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools |  
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author driques
 */
public class Document{
    //Representacion
    //creador, IDdoc, dateDoc,content,share
    private String owner;
    private int idDoc;
    private int idVer;
    private Date dateDoc;
    private String content;
    private String nameDoc;
    private ArrayList<Access> share;
    
    
    //Constructor
    public Document(String username, int id,String nombreDoc,String contenido){
        this.owner = username;
        this.idDoc = id;
        this.idVer = 0;
        this.nameDoc = nombreDoc;
        this.dateDoc = new Date();
        this.content = contenido;
        this.share = new ArrayList<>();
        }
    //Constructor copia
    public Document(Document copy){
        this.owner = copy.getDocOwner();
        this.idDoc = copy.getDocId();
        this.idVer = copy.getDocIdVer();
        this.nameDoc = copy.getDocName();
        this.dateDoc = copy.getDocDate();
        this.content = copy.getDocContent();
        this.share = copy.getDocShare();
        }
    
    //Getters
    public String getDocOwner(){
        return this.owner;   
    }
     public String getDocName(){
        return this.nameDoc;   
    }
    public int getDocId(){
        return this.idDoc;   
    }
    public int getDocIdVer(){
        return this.idVer;   
    }
    public String getDocContent(){
        return this.content;
    }
    public Date getDocDate(){
        return this.dateDoc;   
    }
    
    public ArrayList<Access> getDocShare(){
        return this.share;   
    }
    
    //Setters 
    public void setIdVer(int newVer){
        this.idVer = newVer;
    }
    
    public void setContent(String newContent){
        this.content = newContent;
    
    }
    //Métodos
    
    //addShare
    //Agrega a usuarios a la lista de share del documento
    
    public void addShare(Access addUser){
       this.share.add(addUser);
    }
    
    public void revokeAllAccess(){
        this.share = new ArrayList<>();
    }
    
    
    //isShare verifica que al usuario ingresado se le haya compartido
    //el documento en cualquiera de sus formas, es decir, comentario, lectura o escritura.
    public boolean isShare(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)){
                return true;
            }
        }
            
        return false;
    }
    
    
    public boolean isWritter(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)&& share.get(i).getAccess().equals("escritura")){
                return true;
            }
        }
            
        return false;
    
    }
    public boolean isReader(String user){
        int sizeShare = this.share.size();
        for(int i = 0;i<sizeShare;i++){
            if(share.get(i).getUserAccess().equals(user)&& share.get(i).getAccess().equals("lectura")){
                return true;
            }
        }
            
        return false;
    
    }
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
        
   

