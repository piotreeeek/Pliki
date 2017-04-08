package zadanie3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Piotrek on 2017-04-07.
 */
public class ReadSpace implements MyFileReader{
    File file;

    public ReadSpace(File file){
        this.file = file;
    }

    @Override
    public String readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String fileText = null;
        try {
            fileText = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringTokenizer st = new StringTokenizer(fileText);
        fileText = "";
        while (st.hasMoreTokens()) {
            fileText += st.nextToken() + "\t";
        }
        fileText = fileText.trim();
        return fileText;
    }
}
