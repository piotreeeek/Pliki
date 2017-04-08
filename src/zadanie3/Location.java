package zadanie3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-04-09.
 */
public class Location
{
    static List<MyFileReader> listFiles(String filePath) {
        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles(filter);
        List<MyFileReader> listOfFileReaders = new ArrayList<MyFileReader>();

        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                File file = listOfFiles[i];
                if (file.getName().startsWith("rodzaj_1")) {
                    listOfFileReaders.add(new ReadSpace(file));
                } else if (file.getName().startsWith("rodzaj_2")) {
                    listOfFileReaders.add(new ReadEnter(file));
                }
            }
            if (listOfFileReaders.size() == 0){
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            System.out.println("Searched file not present in directory or directory not valid");
        }
        return listOfFileReaders;
    }
}
