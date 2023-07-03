package org.project.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

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

    /*
    * @return String path of new file
    * @arguments String name of file and extension TODO: validate if don't have extension
    * method used for create a new file in currently path
    * */
    public String createFileInCurrentlyFolder(String path) throws IOException {
        try{
            this.currentlyPath = String.format("%s/%s", this.currentlyPath, path);
            File newFile = new File(this.currentlyPath);
            newFile.createNewFile();
        }catch(Exception error){
            System.out.println("can't create the file about us :" + error.getMessage().toString());
        }
        return path;
    }

    /*
    * @return boolean if it can be renamed the folder
    * @arguments (Integer keyFolder, String new name)
    * @keyFolder is the key for search the key associate of value
    * @NewName is the new name for rename
    * this method has some validations and is used for rename folder or file
    * */
    public void  modifyNameOfFolderOrFile(Integer keyFolder, String newName) {
        Map<Integer, String> contentOfCurrentlyPath = getAllFolderWithNotPath();
        String nameFoundInListOfContent = FolderUtils.getNameOfItemFoundWithKey(contentOfCurrentlyPath, keyFolder);

        File fileForModified = new File(nameFoundInListOfContent);

        // THIS METHOD INVOCATION IS USED FOR VALIDATE IF IS FOLDER OR FILE
        String foundedType = FolderUtils.validateIfIsFolderOrFile(nameFoundInListOfContent);

        if(Objects.equals(foundedType, "FOLDER")) {
            File modifiedFolder = new File(newName);
            fileForModified.renameTo(modifiedFolder);
            return;
        }

        //IN THIS SITUATION WE KNOW THE FILE FOR MODIFIED IS A FILE AND GOT EXTENSION
        File modifiedFile = new File(newName.concat(foundedType));
        fileForModified.renameTo(modifiedFile);
    }


}
