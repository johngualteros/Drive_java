package org.project.services;

import org.project.models.Folder;

import java.io.IOException;
import java.util.Scanner;

/*
* Menu Service class is used for show the different options of application
* */
public class MenuService {

    /*
    * option is used for save the option of user
    * */
    static int option = 0;

    /*
    * path is used for save the name the file or folder
    * */
    static String path;

    /*
    * name is used for rename file or folder
    * */
    static String name;

    /*
    * reader is used for scan the input of user
    * */
    static Scanner reader = new Scanner(System.in);

    /*
    * folderService is used for invoke the methods depends on option user selected
    * */
    private static FolderService folderService = new FolderService();


    /*
    * this method only is used for show in console the main menu
    * */
    public static void showMainMenu() {
        System.out.println("DRIVE APP JAVA APPLICATION");
        System.out.println("1 - Create the folder in te currently folder ");
        System.out.println("2 - Create the file in the currently folder");
        System.out.println("3 - Move to folder");
        System.out.println("4 - Change name of folder/file");
        System.out.println("**********************CONTENT OF FOLDER**********************");
    }

    /*
    * Choice the first option and implement all functionalities
    * */
    public static void ChoiceFirstOption() throws IOException {
        System.out.print("Select Option: ");
        option = reader.nextInt();
        reader.reset();
        OperatievSystem.clearConsole();
        if (option == 1){
            System.out.print("Enter the name of new folder : ");
            path = reader.next();
            folderService.createFolderInCurrentlyFolder(path);
        } else if(option == 2){
            System.out.print("Enter the name of new file and extension (example.java): ");
            path = reader.next();
            folderService.createFileInCurrentlyFolder(path);
        } else if(option == 3){
            return;
        } else if(option == 4){
            System.out.print("Select the number of file you wanna modifier: ");
            option = reader.nextInt();
            /*ENTER NAME OF NEW FOLDER*/
            System.out.println("Enter the name of new folder");
            name = reader.next();
            folderService.modifyNameOfFolderOrFile(option, name);
        } else {
            System.out.println("Option not supported");
        }
        folderService.getAllFolderWithNotPath();
    }


}
