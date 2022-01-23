/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoParadigmasPOO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author driques
 */





public class Menu{
    private ParadigmaDocs platform;
    Scanner inputInt = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
       
    public Menu(){
        platform = new ParadigmaDocs();
    }
    public void runMenu(){
        platform.register("driques", "123");
        platform.login("driques", "123");
        create("doc 1 driques","content test");
        create("otro doc test","este es otro test para driques");
        create("Estoy aprendiendo Java", "Cree este documento porque estoy aprendiendo Java");
        platform.logout();
        
        
        platform.register("peter", "holaPeter");
        platform.login("peter", "holaPeter");
        create("Test para peter", "Hola peterrrrr");
        create("Este es otro test de peter","soy petar parkaaar");
        create("ultimo texto","Tu peter del flow ya tu sae");
        
        platform.logout();
        
        platform.register("americo", "amorir");
        platform.login("americo", "amorir");
        create("Este es el embrujooo","A morirrrrrr");
        create("Grupo alegriaaaaaa","No te sientas mal, amigo nada mas de la cervecitaaaa!!!!");
        
        platform.logout();
        
        platform.register("user", "pass");
        platform.login("user", "pass");
        create("Lorem ipsum","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.");
        
        platform.logout();
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
                                +"\n 3) Salir"
                                +"\n 4) Mostrar plataforma");
           

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
                case 4:
                    printEditor(editorToString(platform));
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
        if(platform.login(loginUser,loginPass)){
            String getOptionLogin;
            boolean logout = false;
            System.out.println("---------LOGIN EXITOSO---------");
            System.out.println("---------ENTRANDO EN EL SISTEMA---------");
            do{
                
                System.out.println("Usuario activo: "+platform.getActiveUser());
                System.out.println("==OPCIONES==");
                System.out.println("1.Crear un nuevo documento");
                System.out.println("2.Compartir documento");
                System.out.println("3.Agregar contenido a un documento");
                System.out.println("4.Restaurar version a un documento");
                System.out.println("5.Revocar acceso a un documento");
                System.out.println("6.Buscar en los documentos");
                System.out.println("7.Visualizar documentos");
                System.out.println("8.Buscar y reemplazar");
                System.out.println("9.Cerrar sesion");
                System.out.println("10.Cerrar programa");
                
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
                            
                            
                            
                        if(platform.getPlatformDocs().get(idInt).getDocOwner().equals(platform.getActiveUser())){
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
                        switch (typeAccess) {
                            case "1":
                                typeAccess="lectura";
                                break;
                            case "2":
                                typeAccess="escritura";
                                break;
                            case "3":
                                typeAccess="comentario";
                                break;
                            default:
                                break;
                        }
                            
                                   
                            for(int i = 0;i<sizeShareUsers;i++){
                                if(platform.isRegister(shareUsers[i])){
                                    //Crear un objeto de tipo access
                                    Access accesoDoc = new Access(shareUsers[i],typeAccess);
                                    platform.getPlatformDocs().get(idInt).addShare(accesoDoc);
                                   
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
                        
                        System.out.println("Agregando contenido . . . ");
                        //Scanner
                        Scanner textToAdd = new Scanner(System.in);
                        Scanner inputDoc =  new Scanner(System.in);
                        System.out.println("Seleccione id documento para agregar contenido: ");
                        String getIdDocStr = inputDoc.next();
                        
                        
                        while (isNumeric(getIdDocStr)==false){
                            System.out.println("Ingresa un numero!");
                            getIdDocStr = inputDoc.next();
                        }
                        int getIdDoc = Integer.parseInt(getIdDocStr);
                        
                        
                        
                        
                        try{
                            getIdDoc = getIdDoc -1;
                            
                            if((platform.getPlatformDocs().get(getIdDoc).getDocOwner().equals(platform.getActiveUser())) || 
                                    (platform.getPlatformDocs().get(getIdDoc).isWritter(platform.getActiveUser()))){ 
                                System.out.println("Contenido a agregar: ");
                                String toAdd = textToAdd.nextLine();
                                
                                
                                Document lastDoc = new Document(platform.getPlatformDocs().get(getIdDoc));
                                platform.addDocVer(lastDoc);
                                
                                String addContent = platform.getPlatformDocs().get(getIdDoc).getDocContent() + toAdd;
                                int newVersion=  platform.getPlatformDocs().get(getIdDoc).getDocIdVer() + 1;
                                
                                platform.getPlatformDocs().get(getIdDoc).setIdVer(newVersion);
                                platform.getPlatformDocs().get(getIdDoc).setContent(addContent);

                      
                            }
                            else{
                                 System.out.println("\nOpcion no valida!\n");
                            }
                            
                        }catch (Exception e){
                            System.out.println("Documento invalido o entrada no valida!");
                        }
                        
                        
                        break;
                        
                        
                        
                    case 4:
                        System.out.println("ROLLBACK . . . ");
                         //Scanner
                        Scanner inputRoll = new Scanner(System.in);                      
                        Scanner inputId = new Scanner(System.in);
                        System.out.println("Seleccione id documento para hacer el rollback: ");
                        String docIdToRollbackStr = inputId.next();
                        
                        while (isNumeric(docIdToRollbackStr)==false){
                            System.out.println("Ingresa un numero!");
                            docIdToRollbackStr = inputId.next();
                        }
                        int docIdToRollback = Integer.parseInt(docIdToRollbackStr);
                        
                        
                        
                        
                        System.out.println("Seleccione id de la version del documento para hacer el rollback ");
                        String docVerToRollbackStr = inputRoll.next();
                        
                        
                        while (isNumeric(docVerToRollbackStr)==false){
                            System.out.println("Ingresa un numero!");
                            docVerToRollbackStr = inputRoll.next();
                        }
                        int docVerToRollback = Integer.parseInt(docVerToRollbackStr);
                        
                        
                        
                        try{
                            docIdToRollback = docIdToRollback -1;
                            
                            int maxVerId = platform.maxIdVer(docIdToRollback);
                            
                            if(platform.getPlatformDocs().get(docIdToRollback).getDocOwner().equals(platform.getActiveUser()) &&
                                    maxVerId>=docVerToRollback){
                                
                                Document lastDoc = new Document(platform.getPlatformDocs().get(docIdToRollback));
                               
                                platform.addDocVer(lastDoc);
                              
                                Document toRollback = platform.searchByIDVer(docIdToRollback, docVerToRollback);
                                
                                platform.removeDocVer(toRollback);
                               
                                platform.addDoc(toRollback, docIdToRollback);
                               
                            }
                            else{
                                 System.out.println("\nOpcion no valida!\n");
                            }
                            
                        }catch (Exception e){
                            System.out.println("Documento invalido o entrada no valida!");
                        }
                        
                        //
                        break;
                        
                        
                        
                        
                        
                    case 5:
                        System.out.println("RevokeAllAccess");
                         //Scanner
                        Scanner idToRevoke = new Scanner(System.in);
                        System.out.println("Seleccione id documento para hacer el revoke: ");
                        String docIdToRevokeStr = idToRevoke.next();
                        
                        
                        while (isNumeric(docIdToRevokeStr)==false){
                            System.out.println("Ingresa un numero!");
                            docIdToRevokeStr = idToRevoke.next();
                        }
                        int docIdToRevoke = Integer.parseInt(docIdToRevokeStr);
                        
                        
                        try{
                            docIdToRevoke = docIdToRevoke -1;
                            
                            if(platform.getPlatformDocs().get(docIdToRevoke).getDocOwner().equals(platform.getActiveUser())){
                                platform.getPlatformDocs().get(docIdToRevoke).revokeAllAccess();
                                System.out.println("\nUsuarios revocados correctamente!\n");
                            }
                            else{
                                System.out.println("\nOpcion no valida!\n");
                            }
                            
                        }catch (Exception e){
                            System.out.println("Documento invalido o entrada no valida!");
                        }
                        
                        break;
                        
                    case 6:
                        System.out.println("Search");
                         //Scanner
                        Scanner stringContains = new Scanner(System.in);
                        System.out.println("Escriba el texto a buscar en los documentos: ");
                        String textContains = stringContains.nextLine();
                        
                        ArrayList<String> textosEncontrados = platform.search(platform.getActiveUser(),textContains);
                        
                        int sizeEncontrados = textosEncontrados.size();
                        
                        if(sizeEncontrados>0){
                            for(int i = 0;i<sizeEncontrados;i++){
                                System.out.println(textosEncontrados.get(i));
                            }
                        }else{
                            System.out.println("No hay coincidencias");
                        }
                        
                        stringContains.close();
                        
                        
                        
                        break;
                    case 7:
                        printEditor(editorToString(platform));
                        break;
                        
                    case 8:
                        System.out.println("Search and replace");
                         //Scanner
                        Scanner toSearchId = new Scanner(System.in);
                        System.out.println("Escriba el id del documento: ");
                        String stringToSrch = toSearchId.nextLine();
                        
                      
                        while (isNumeric(stringToSrch)==false){
                            System.out.println("Ingresa un numero!");
                            stringToSrch = toSearchId.next();
                        }
                        int searchId = Integer.parseInt(stringToSrch);
                        
                      
                        //
                        Scanner toSearch = new Scanner(System.in);
                        System.out.println("Escriba el texto a buscar en los documentos: ");
                        String textoContenido = toSearch.nextLine();
                        //
                        Scanner toReplace = new Scanner(System.in);
                        System.out.println("Escriba el texto a buscar en los documentos: ");
                        String textoReemplazar = toReplace.nextLine();
                        
                        if(platform.searchAndReplace(searchId, textoContenido, textoReemplazar)){
                            System.out.println("Reemplazado con exito!");
                        }else {
                            System.out.println("Sin coincidencias");
                        }
                       
                        
                        
                        /*
                        ArrayList<String> found = platform.search(platform.getActiveUser(),stringToSrch);
                        
                        int sizeFound = found.size();
                        
                        if(sizeFound>0){
                            for(int i = 0;i<sizeFound;i++){
                                
                            }
                        }else{
                            System.out.println("No hay coincidencias");
                        }*/
                        
                        
                        
                        break;
                    case 9:
                        platform.logout();
                        logout = true;
                        return false;
                       
                    case 10:
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
        if(platform.register(registerUser, registerPass)){
            System.out.println("---------REGISTRO EXITOSO---------");
            return true;
            
        }
        else{
            System.out.println("---------USUARIO YA REGISTRADO---------");
            return false;
     
        
        }
    }
    
    
    public String shareToString(ArrayList<Access> accesos){
        int sizeAccess = accesos.size();
        String accesses = "";
        for(int i =0; i<sizeAccess;i++){
            accesses=accesses.concat("Compartido con: "+accesos.get(i).getUserAccess()+"\n");
            accesses=accesses.concat("En modo: "+accesos.get(i).getAccess()+"\n");
        }
        return accesses;
    
    }
    
    private void create(String nombreDoc, String content){
        int tamanioDocs = platform.getPlatformDocs().size();
        Document createDoc = new Document(platform.getActiveUser(),tamanioDocs+1,nombreDoc,content);
        platform.addDoc(createDoc);
    }
    public static boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    
    public void printEditor(String editorToPrint){
        System.out.print(editorToPrint);  
    }
    
    public String editorToString(ParadigmaDocs platform){
        if(platform.getActiveUser()==(null)){
            String toReturn = " ";
            int sizeDocs = platform.getPlatformDocs().size();
            for(int i = 0;i<sizeDocs ; i++){
               toReturn = toReturn.concat("ID doc = "+ platform.getPlatformDocs().get(i).getDocId()+"\n");
               toReturn = toReturn.concat("ID doc version = "+ platform.getPlatformDocs().get(i).getDocIdVer()+"\n");
               toReturn = toReturn.concat("Propietario = "+ platform.getPlatformDocs().get(i).getDocOwner()+"\n");
               toReturn = toReturn.concat("Contenido = "+ platform.getPlatformDocs().get(i).getDocContent()+"\n");
               toReturn = toReturn.concat("=================================================\n");
                
            }
            
            return toReturn;
                
        }
        else{
            System.out.println("Documentos . . . ");
            String toReturn = " ";
            int lenDocs = platform.getPlatformDocs().size();
            for(int i = 0; i< lenDocs; i++){
                if(platform.getPlatformDocs().get(i).getDocOwner().equals(platform.getActiveUser())){
                    System.out.println(i+1+"<- id doc) nombre documento: "+platform.getPlatformDocs().get(i).getDocName());
                }
                if(platform.getPlatformDocs().get(i).isShare(platform.getActiveUser())){
                    System.out.println("DOCUMENTO COMPARTIDO");
                    System.out.println(i+1+"<- id doc) nombre documento: "+platform.getPlatformDocs().get(i).getDocName());
                    if(platform.getPlatformDocs().get(i).isWritter(platform.getActiveUser())){
                        System.out.println("En modo escritura.");
                    }
                    if(platform.getPlatformDocs().get(i).isReader(platform.getActiveUser())){
                        System.out.println("En modo lector.");
                    }
                    if(platform.getPlatformDocs().get(i).isComment(platform.getActiveUser())){
                        System.out.println("En modo comentario.");
                    }
                }

            }
            System.out.println("Seleccione id documento para ver contenido: ");
            Scanner getDocToWatch = new Scanner(System.in);
            String getDocStr = getDocToWatch.next();


            while (isNumeric(getDocStr)==false){
                System.out.println("Ingresa un numero!");
                getDocStr = getDocToWatch.next();
            }
            int getDoc = Integer.parseInt(getDocStr);



            try{
                getDoc = getDoc -1;
                if(platform.getPlatformDocs().get(getDoc).getDocOwner().equals(platform.getActiveUser())||platform.getPlatformDocs().get(getDoc).isShare(platform.getActiveUser())){
                    toReturn = toReturn.concat("============================================================================\n");
                    toReturn = toReturn.concat("Contenido: "+platform.getPlatformDocs().get(getDoc).getDocContent()+"\n");
                    toReturn = toReturn.concat("Creado el: "+platform.getPlatformDocs().get(getDoc).getDocDate()+"\n");
                    toReturn = toReturn.concat("ID del documento: "+platform.getPlatformDocs().get(getDoc).getDocId()+"\n");
                    toReturn = toReturn.concat("ID de la version: "+platform.getPlatformDocs().get(getDoc).getDocIdVer()+"\n");
                    toReturn = toReturn.concat(shareToString(platform.getPlatformDocs().get(getDoc).getDocShare())+"\n");
                    toReturn = toReturn.concat("=============================================================================\n");

                }
                else{
                     System.out.println("\nOpcion no valida!\n");
                }

            }catch (Exception e){
                System.out.println("Documento invalido o entrada no valida!");
            }
                        
            return toReturn;
        }
    
    }
    
}
