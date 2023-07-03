package org.project.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Final class why can't subclasses inherit this class
 * @Important this class is for utils we can use in folder service
 * */
public final class FolderUtils {

    /*
    * @Type AtomicInteger why the index is mutable
    * */
    static AtomicInteger index = new AtomicInteger(1);

    /*
    * @Map<Integer, String> return key and the path
    * this method is used for convert the array for hashMap
    * */
    public static Map<Integer, String> convertArrayToMap (String[] array) {

        List<String> arrayConvertedToList = Arrays.stream(array).toList();

        Map<Integer, String> contentFolder = new HashMap<>();

        arrayConvertedToList.forEach((item)  -> {
            contentFolder.put(Integer.parseInt(String.valueOf(index)), item);
            index.getAndIncrement();
        });

        ShowFolderService.showContentOfFolder(contentFolder);

        index.set(1);

        return contentFolder;
    }

    /*
    * @return String return name of folder or file found with key parameter
    * this method is used for search a folder value with key Integer parameter
    * */
    public static String getNameOfItemFoundWithKey(Map<Integer, String> mapOfContent, Integer key) {
        if(!mapOfContent.containsKey(key)){
            return "Key not found in the list";
        }
        return mapOfContent.get(key);
    }

    /*
    * @return String return FOLDER or EXTENSION depends on if the name has extension or not
    * this method is used for validate if the name passed in arguments has extension file or not
    * */
    public static String validateIfIsFolderOrFile(String name) {
        try {
            String extension = name.substring(name.lastIndexOf("."));

            //Checks if there is any extension after the last . in your input
            if (extension.contains(".")) {
                System.out.println("This is the extension - " + extension);
                return extension;
            }
        }catch(Exception e) {
            System.out.println("not got extension the name: " + name);
            return "FOLDER";
        }
        return name;
    }

}
