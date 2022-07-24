package FileHandling;
import java.io.FileWriter;
import java.io.IOException;


public class Append {
    public static void main(String[] args) {
    	String data = "This data is appended";
    	try {
			FileWriter output = new FileWriter("Newfile.txt",true);
			output.write(data);
			System.out.println("Data appended successfully");
			output.close();
		} catch (IOException e) {
			System.out.println("File append error");
			
			e.printStackTrace();
		}
    }
}