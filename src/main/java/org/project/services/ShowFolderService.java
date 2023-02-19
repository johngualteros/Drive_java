package org.project.services;

import java.util.Map;

/*
* ShowFolderService is used to show the folders to user
* */
public class ShowFolderService {

    /*
    * @return void
    * This method is used for travel the HashMap and show the key value for users
    * */
    public static void showContentOfFolder (Map<Integer, String> contentFolder) {
        contentFolder.forEach((key, value) -> System.out.printf("%s - %s", key , value));
    }

}
