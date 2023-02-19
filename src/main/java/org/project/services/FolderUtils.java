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
}
