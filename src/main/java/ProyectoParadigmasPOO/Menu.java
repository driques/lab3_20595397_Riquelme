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
    ParadigmaDocs pDocs = new ParadigmaDocs();
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
                case 4:// <- esto se elimina
                    //TEST USUARIOS REGISTRADOS
                     System.out.println("USUARIOS REGISTRADOS . . . ");
                     int lenUsersReg = pDocs.getRegisterUsers().size();
                     for(int i = 0; i< lenUsersReg; i++){
                         System.out.println("User "+i +" "+pDocs.getRegisterUsers().get(i).getUsername());
         
                     }
                     break;
                     
                     
                default:
                    System.out.println("\n¡Opcion no valida!\n");
                    break; 

            }
        }while(option!=3);
    }
    
    
    
    private boolean case1(){
        System.out.println("---------LOGIN---------");
        System.out.println("Ingresa usuario: ");
        String loginUser = inputStr.next();
        System.out.println("Ingresa contrasenia: ");
        String loginPass = inputStr.next();
        //Se loguea
        if(pDocs.login(loginUser,loginPass)){
            System.out.println("---------LOGIN EXITOSO---------");
            System.out.println("---------ENTRANDO EN EL SISTEMA---------");
            return true;
            
        }
        else{
            System.out.println("---------ERROR EN EL USUARIO O CONTRASENIA---------");
            return false;
        }
        
    
    
    }
    private boolean case2(){
        System.out.println("---------REGISTRO---------");
        System.out.println("Ingresa nuevo usuario: ");
        String registerUser = inputStr.next();
        System.out.println("Ingresa una contrasenia: ");
        String registerPass = inputStr.next();
        //Se registra 
        if(pDocs.register(registerUser, registerPass)){
            System.out.println("---------REGISTRO EXITOSO---------");
            return true;
            
        }
        else{
            System.out.println("---------USUARIO YA REGISTRADO---------");
            return false;
        }
    }   
    
    
}
