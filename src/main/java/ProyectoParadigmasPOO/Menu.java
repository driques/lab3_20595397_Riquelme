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
        String optionStr;
        do{
            System.out.println("\n 1) Iniciar sesion"
                                +"\n 2) Registrarse"
                                +"\n 3) Salir");
           

            optionStr = inputInt.next();
            while (isNumeric(optionStr)==false){
                System.out.println("Ingresa un numero!");
                 optionStr = inputInt.next();
                }
            int option  = Integer.parseInt(optionStr);
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
                    System.out.println("\nOpcion no valida!\n");
                    break; 

                }
            
        
        }while(true);
    }
    
    
    
    private boolean case1(){
        System.out.println("---------LOGIN---------");
        System.out.println("Ingresa usuario: ");
        String loginUser = inputStr.next();
        System.out.println("Ingresa contrasenia: ");
        String loginPass = inputStr.next();
        //Se loguea
        if(pDocs.login(loginUser,loginPass)){
            String getOptionLogin;
            boolean logout = false;
            do{
                System.out.println("---------LOGIN EXITOSO---------");
                System.out.println("---------ENTRANDO EN EL SISTEMA---------");
                System.out.println("Usuario activo: "+pDocs.getActiveUser());
                System.out.println("==OPCIONES==");
                System.out.println("1.Crear un nuevo documento");
                System.out.println("2.Compartir documento");
                System.out.println("3.Agregar contenido a un documento");
                System.out.println("4.Restaurar version a un documento");
                System.out.println("5.Revocar acceso a un documento");
                System.out.println("6.Buscar en los documentos");
                System.out.println("7.Visualizar documentos");
                System.out.println("8.Cerrar sesion");
                System.out.println("9.Cerrar programa");
                System.out.println("Introduza la opcion: ");
                getOptionLogin = inputStr.next();
                while (isNumeric(getOptionLogin)==false){
                    System.out.println("Ingresa un numero!");
                    getOptionLogin = inputInt.next();
                }
                int intOpt  = Integer.parseInt(getOptionLogin);
                
                switch(intOpt){
                    case 1:
                        Scanner inputName = new Scanner(System.in);
                        Scanner inputContent = new Scanner(System.in);
                        String nameDoc;
                        String contentDoc ;
                        System.out.println("option 1");
                        System.out.println("Ingresa un nombre para el documento: ");
                        nameDoc = inputName.nextLine();
                        System.out.println("Ingresa contenido: ");
                        contentDoc = inputContent.nextLine();
                        create(nameDoc,contentDoc);
                        System.out.println("Documento creado con exito!");
                       
                        
                        break;
                           
                    case 2:
                        System.out.println("option 2");
                        break;
                    case 3:
                        System.out.println("option 3");
                        break;
                    case 4:
                        System.out.println("option 4");
                        break;
                    case 5:
                        System.out.println("option 5");
                        break;
                    case 6:
                        System.out.println("option 6");
                        break;
                    case 7:
                        System.out.println("option 7");
                        System.out.println("Documentos . . . ");
                        int lenDocs = pDocs.getPlataformDocs().size();
                        for(int i = 0; i< lenDocs; i++){
                            if(pDocs.getPlataformDocs().get(i).getDocOwner().equals(pDocs.getActiveUser())){
                                System.out.println(i+1+"<- id doc) nombre documento: "+pDocs.getPlataformDocs().get(i).getDocName());
                            }
                        }
                        System.out.println("Seleccione id documento para ver contenido: ");
                        int getDoc = inputInt.nextInt();
                        try{
                            getDoc = getDoc -1;
                            System.out.println("Contenido: "+pDocs.getPlataformDocs().get(getDoc).getDocContent());
                        }catch (Exception e){
                            System.out.println("Documento invalido o entrada no valida!");
                        }
                        System.out.println("Pulsa enter para continuar . . .1");
                        break;
                        
                    case 8:
                        pDocs.logout();
                        logout = true;
                        return false;
                    case 9:
                        System.out.println("Hasta pronto . . . ");
                        System.exit(0);
                        break;
                
                
                
                }
            }while(logout == false);
            
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
    
    private void create(String nombreDoc, String content){
        int tamanioDocs = pDocs.getPlataformDocs().size();
        Document createDoc = new Document(pDocs.getActiveUser(),tamanioDocs+1,nombreDoc,content);
        pDocs.addDoc(createDoc);
    }
    public static boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
