package zadanie3;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Piotrek on 2017-04-07.
 */
public class Start {
    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner scan = new Scanner(System.in);
        String filePath;

        System.out.println("Podaj sciezke do folderu:");
        filePath = scan.nextLine();

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles(filter);
        List<CzytnikPliku> listOfFileReaders = new ArrayList<CzytnikPliku>();

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
            System.out.println("Searched file not present in directory");
        }

        for (final CzytnikPliku fileRed: listOfFileReaders) {
            System.out.println(fileRed.readFile());
        }

    }
}
