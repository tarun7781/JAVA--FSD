package FileHandling;
import java.io.File;
import java.io.IOException;

public class Create {
    public static void main(String[] args) {

        File myFile = new File("Newfile.txt");
        try {
            myFile.createNewFile();
            System.out.println("File created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
