/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

/**
 *
 * @author driques
 */
public class Main {
   
    public static void main(String[] args) {
        User nuevoUsuario = new User ("driques","password123");
        System.out.println(nuevoUsuario.getUsername()); 
        System.out.println(nuevoUsuario.getDate()); 
   
    }
    
}
