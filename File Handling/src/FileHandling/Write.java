package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {

        @SuppressWarnings("unused")
		File myFile = new File("Newfile.txt");
        try {
            FileWriter fileWriter = new FileWriter("Newfile.txt");
            fileWriter.write("Writing the file");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}