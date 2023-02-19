package org.project.services;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
* Folder service class for make the methods how show folders
* */
public class FolderService {

    /*
    * Variable to create the main File path
    * */
    File theDir = new File("/drive");

    /*
    * Variable to concat the path and update in global scope
    * */

    String currentlyPath = "/drive";

    /*
    *  @return void
    *   this method is for create the main directory if not exists
    * */

    public void createMainDirectory() {
        if (!theDir.exists()){
            System.out.println("Create the main directory");
            theDir.mkdirs();
            return;
        }
        System.out.println("i don't create the directory why it already exists");
    }

    /*
    * @return Map<Integer, String>
    * is used for get the directories of main path
    * */
    public Map<Integer, String> getAllFolderWithNotPath() {
        String[] contentFolder = this.theDir.list();
        return FolderUtils.convertArrayToMap(contentFolder);
    }

    /*
    * @return Map<Integer, String>
    * @argument String path
    * is used for get the directories in specific path argument
    * */
    public Map<Integer, String> getAllFoldersWithPath(String path) {
        this.currentlyPath = String.format("%s/%s", this.currentlyPath, path);
        File file = new File(this.currentlyPath);
        String[] contentPath = file.list();
        return FolderUtils.convertArrayToMap(contentPath);
    }

    /*
    * @return String the path of create folder
    * @argument String path (name of folder)
    * create the folder if not exists
    * */

    public String createFolderInCurrentlyFolder(String path) {
        this.currentlyPath = String.format("%s/%s", this.currentlyPath, path);
        File newFolder = new File(this.currentlyPath);
        if(!newFolder.exists()){
            newFolder.mkdirs();
        }
        return path;
    }


}
