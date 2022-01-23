/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.Date;

/**
 * Comment representa un comnetario dentro de un documento, con los argumentos de
 * id, fecha, usuario que crea el comentario, el comentario en si, y el documento al cual esta asociado.
 * @author driques
 */
public class Comment {
    
    //Atributos
    private int idComment;
    private Date dateComment;
    private String ownerComment;
    private String comment;
    private Document doc;
    /**
     * Este es el constructor para los objetos de tipo Comment.
     * @param id es el id
     * @param owner el que crea el comentario
     * @param comment el comentario
     * @param doc el documento 
     */
    public Comment(int id, String owner, String comment,Document doc){
        this.idComment = id;
        this.dateComment = new Date();
        this.ownerComment = owner;
        this.comment = comment;
        this.doc = doc;
       
    }
    
     /** 
     *
     * Get al id del comentario.
     *
     * @return the identifier.
     */
    
    public int getIdComment(){
        return this.idComment;
    }
    /**
     * Get a la fehca del comentario.
     * @return la fecha del comentario.
     */
    public Date getDateComment(){
        return this.dateComment;
               
    }
    /**
     * Get al usuario que escribio el comentario.
     * @return el usuario que escribio el comentario.
     */
    public String getOwnerComment(){
        return this.ownerComment;
                
    }
    /**
     * Get al contenido del comentario.
     * @return el contenido del comentario.
     */
    public String getCommentContent(){
        return this.comment;
    }
    
    /**
     * Get al documento del comentario asociado.
     * @return el documento
     */
    public Document getDocComment(){
        return this.doc;    
    }
    
    
}
