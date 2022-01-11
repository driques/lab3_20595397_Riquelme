/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;

import java.util.Scanner;


/**
 *
 * @author driques
 */
public class Main {
    public static void main(String[] args) {
        User nuevoUsuario = new User ("driques","password123");
        
        //Menu
                
        // Menú interactivo
        System.out.println("\n");
        System.out.println("************************************\n");
        System.out.println("**        -PARADIGMADOCS-       **\n");
        System.out.println("************************************\n");
        Scanner input = new Scanner(System.in);
        int option;
                  
        do{
            System.out.println("\n 1) Iniciar sesion"
                                +"\n 2) Registrarse"
                                +"\n 3) Salir");
            
            option = input.nextInt();
            
            switch(option){
                case 1:
                       System.out.println("Iniciando sesion . . .");
                       break;
                       
                case 2:
                       System.out.println("Registrarse . . ."); 
                       break;
                case 3:
                    System.out.println("Hasta pronto . . . ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n¡Opcion no valida!\n");
                    break; 

            }
        }while(option!=3);
        
     
      
        
        
        
        
    }
    
}
