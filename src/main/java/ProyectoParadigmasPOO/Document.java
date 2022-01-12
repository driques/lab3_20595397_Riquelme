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
public class Document {
    //Representacion
    //creador, IDdoc, dateDoc,content,share
    private String owner;
    private int idDoc;
    private Date dateDoc;
    private String content;
    private ArrayList<String> share;
    
    
    //Constructor
    public Document(String username, int id, String contenido){
    this.owner = username;
    this.idDoc = id;
    this.dateDoc = new Date();
    this.content = contenido;
    this.share = new ArrayList<>();
    }
    //Selectores
    public String getDocOwner(){
        return this.owner;   
    }
    public int getDocId(){
        return this.idDoc;   
    }
    public Date getDocDate(){
        return this.dateDoc;   
    }
    public ArrayList<String> getDocShare(){
        return this.share;   
    }
    //Métodos
    
    //addShare
    //Agrega a usuarios a la lista de share del documento
    
    public void addShare(ArrayList<String> addUser){
    for(int i = 0; i < addUser.size();i++){
        this.share.add(addUser.get(i));
    }
}
    
    
    
}
