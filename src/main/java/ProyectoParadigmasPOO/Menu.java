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
        pDocs.register("driques", "123");
        pDocs.login("driques", "123");
        create("doc 1 driques","content test");
        create("otro doc test","este es otro test para driques");
        create("Estoy aprendiendo Java", "Cree este documento porque estoy aprendiendo Java");
        pDocs.logout();
        
        
        pDocs.register("peter", "holaPeter");
        pDocs.login("peter", "holaPeter");
        create("Test para peter", "Hola peterrrrr");
        create("Este es otro test de peter","soy petar parkaaar");
        create("ultimo texto","Tu peter del flow ya tu sae");
        
        pDocs.logout();
        
        pDocs.register("americo", "amorir");
        pDocs.login("americo", "amorir");
        create("Este es el embrujooo","A morirrrrrr");
        create("Grupo alegriaaaaaa","No te sientas mal, amigo nada mas de la cervecitaaaa!!!!");
        
        pDocs.logout();
        
        pDocs.register("user", "pass");
        pDocs.login("user", "pass");
        create("Lorem ipsum","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.");
        
        pDocs.logout();
        String optionStr;
        
        do{
            
            System.out.println("       _____                 \n" +
                                "      |  __ \\                \n" +
                                " _ __ | |  | | ___   ___ ___ \n" +
                                "| '_ \\| |  | |/ _ \\ / __/ __|\n" +
                                "| |_) | |__| | (_) | (__\\__ \\\n" +
                                "| .__/|_____/ \\___/ \\___|___/\n" +
                                "| |                          \n" +
                                "|_|                          ");
            System.out.println("-Para todo lo que quieras escribir-");
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
            System.out.println("---------LOGIN EXITOSO---------");
            System.out.println("---------ENTRANDO EN EL SISTEMA---------");
            do{
                
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
                Scanner catchError = new Scanner(System.in);
                switch(intOpt){
                    case 1:
                        Scanner inputName = new Scanner(System.in);
                        Scanner inputContent = new Scanner(System.in);
                        
                        String nameDoc;
                        String contentDoc ;
                        System.out.println("Ingresa un nombre para el documento: ");
                        nameDoc = inputName.nextLine();
                        System.out.println("Ingresa contenido: ");
                        contentDoc = inputContent.nextLine();
                        create(nameDoc,contentDoc);
                        System.out.println("Documento creado con exito!");
                       
                       
                        
                        break;
                           
                    case 2:
                        
                        //Scanner 
                        Scanner scanAccess = new Scanner(System.in);
                        Scanner scanIdShare = new Scanner(System.in);
                        System.out.println("Ingresa el ID del documento a compartir: ");
                        String idDocToShare = scanIdShare.nextLine();
                        while (isNumeric(idDocToShare)==false){
                            System.out.println("Ingresa un numero!");
                            idDocToShare = inputInt.next();
                            }
                        int idInt  = Integer.parseInt(idDocToShare)-1;
                            
                            
                            
                        if(pDocs.getPlataformDocs().get(idInt).getDocOwner().equals(pDocs.getActiveUser())){
                            System.out.println("Ingresa una lista de usuarios a compartir (separa cada usuario por un guion - ): ");
                            String listToShare = scanIdShare.nextLine();
                            String[] shareUsers = listToShare.split("-");
                            int sizeShareUsers = shareUsers.length;
                            System.out.println("Selecciona el tipo de acceso\n"+
                                                "1) Lectura\n"+
                                                "2) Escritura\n"+
                                                "3) Comentarios\n");
                            String typeAccess = scanAccess.nextLine();
              
                            while (isNumeric(typeAccess)==false && (typeAccess.equals("1") || typeAccess.equals("2")|| typeAccess.equals("3"))){
                                System.out.println("Ingresa un numero!");
                                typeAccess = scanAccess.nextLine();
                                }
                            if(typeAccess.equals("1")){
                                typeAccess="lectura";
                            }else if ( typeAccess.equals("2")){
                                typeAccess="escritura";
                            } else if (typeAccess.equals("3")){
                                typeAccess="comentario";
                            }
                            
                            
                            
                            
                            
                            for(int i = 0;i<sizeShareUsers;i++){
                                if(pDocs.isRegister(shareUsers[i])){
                                    pDocs.getPlataformDocs().get(idInt).addShare(shareUsers[i]);
                                    pDocs.getPlataformDocs().get(idInt).addShare(typeAccess);
                                    System.out.println("Compartido con: "+shareUsers[i]+" con exito!");
                                    
                                }
                                else{
                                    System.out.println("El usuario: "+shareUsers[i]+" no existe!");
                                }
                            
                            }
                            
                        
                        }
                        else{
                            System.out.println("Ingresa un ID valido!");}
                      
                        break;
                        
                    case 3:
                        System.out.println("option 3");
                        break;
                    case 4:
                        System.out.println("option 4 sin implementar");
                        break;
                    case 5:
                        System.out.println("option 5 sin implementar");
                        break;
                    case 6:
                        System.out.println("option 6 sin implementar");
                        break;
                    case 7:
                        
                        System.out.println("Documentos . . . ");
                        int lenDocs = pDocs.getPlataformDocs().size();
                        for(int i = 0; i< lenDocs; i++){
                            if(pDocs.getPlataformDocs().get(i).getDocOwner().equals(pDocs.getActiveUser())){
                                System.out.println(i+1+"<- id doc) nombre documento: "+pDocs.getPlataformDocs().get(i).getDocName());
                                System.out.println("REAL ID TEST ->"+pDocs.getPlataformDocs().get(i).getDocId());
                            }
                        }
                        System.out.println("Seleccione id documento para ver contenido: ");
                        int getDoc = inputInt.nextInt();
                        try{
                            getDoc = getDoc -1;
                            if(pDocs.getPlataformDocs().get(getDoc).getDocOwner().equals(pDocs.getActiveUser())){
                                System.out.println("Contenido: "+pDocs.getPlataformDocs().get(getDoc).getDocContent());
                                System.out.println("Creado el: "+pDocs.getPlataformDocs().get(getDoc).getDocDate());
                                System.out.println("ID del documento: "+pDocs.getPlataformDocs().get(getDoc).getDocId());
                                //Falta crear un toStringShare que permita visualizar de mejor forma el como se
                                //comparten los usuarios
                                System.out.println("Compartido con: "+pDocs.getPlataformDocs().get(getDoc).getDocShare());
                      
                            }
                            else{
                                 System.out.println("\nOpcion no valida!\n");
                            }
                            
                        }catch (Exception e){
                            System.out.println("Documento invalido o entrada no valida!");
                        }
                        System.out.println("Pulsa enter para continuar . . .1");
                        String error = catchError.nextLine();
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
