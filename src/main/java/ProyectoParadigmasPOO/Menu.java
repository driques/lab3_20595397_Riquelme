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
public class Menu{
    private ParadigmaDocs plataform;
    Scanner inputInt = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
    
    public Menu(){
        plataform = new ParadigmaDocs();
    }
    public void runMenu(){
        int option;
        do{
            System.out.println("\n 1) Iniciar sesion"
                                +"\n 2) Registrarse"
                                +"\n 3) Salir");

            option = inputInt.nextInt();

            switch(option){
                case 1:
                       System.out.println("Iniciando sesion . . .");
                       case1();
                       break;

                case 2:
                       System.out.println("Registrarse . . ."); 
                       case2();
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
    private void case1(){}
    private void case2(){}   
    
    
}
