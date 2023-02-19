package org.project.runners;

/*
*  @Main Runner class is the class for execute the code and disengage on main app
* */

import org.project.services.FolderService;
import org.project.services.MenuService;

import java.util.ArrayList;
import java.util.List;

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
    public static void start() {
        folderService.createMainDirectory();
        MenuService.showMainMenu();
        folderService.getAllFolderWithNotPath();
    }


}
