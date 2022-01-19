/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.ArrayList;
import java.util.Date;
import java.lang.Cloneable;

/**
 *
 * @author driques
 */
public class Document implements Cloneable {
    //Representacion
    //creador, IDdoc, dateDoc,content,share
    private String owner;
    private int idDoc;
    private int idVer;
    private Date dateDoc;
    private String content;
    private String nameDoc;
    private ArrayList<String> share;
    
    
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
    
    public ArrayList<String> getDocShare(){
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
    
    public void addShare(String addUser){
       this.share.add(addUser);
    }
    
    public void refreshDocVer(){}
    
  
   
}
        
   

