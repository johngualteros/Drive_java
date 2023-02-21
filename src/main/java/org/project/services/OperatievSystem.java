package org.project.services;


/*
* Operative System class is for methods for operative system windows linux or mac
* */
public class OperatievSystem {

    /*
    * method used for clear the console
    * */
    public static void clearConsole() {
        try{
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            }else{
                Runtime.getRuntime().exec("clear");
            }
        }catch(Exception e){
            System.out.println("can't clear the console why: " + e.getMessage());
        }
    }
}
