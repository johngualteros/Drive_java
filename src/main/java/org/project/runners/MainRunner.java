package org.project.runners;

import org.project.services.FolderService;
import org.project.services.MenuService;

import java.io.IOException;

/*
 *  @Main Runner class is the class for execute the code and disengage on main app
 * */

public class MainRunner {

    /*
    * Reference of service for use the main methods
    * */
    public static FolderService folderService = new FolderService();


    /*
    *  @return (void)
    *  @params (nothing)
    *  static method for not instance and this method is used for start the app
    * */
    public static void start() throws IOException {
        initApplication();
    }


    /*
    * starters methods for init the app
    * */
    public static void initApplication() throws IOException {
        folderService.createMainDirectory();
        MenuService.showMainMenu();
        folderService.getAllFolderWithNotPath();
        MenuService.ChoiceFirstOption();
    }


}
