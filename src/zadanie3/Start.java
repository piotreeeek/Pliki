package zadanie3;

import java.io.IOException;
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

        List<MyFileReader> listOfFiles = Location.listFiles(filePath);

        for (MyFileReader fileRed: listOfFiles) {
            System.out.println(fileRed.readFile());
        }

    }
}
