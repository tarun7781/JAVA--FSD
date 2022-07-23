package EmailValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
   private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
   public static void main(String args[]) {
       List<String> emails = new ArrayList<String>();
       emails.add("tarun@gmail.com");
       emails.add("tarun.penubarthi@gmail.co.in");
       emails.add("tarun01@gmail.me.org");
       emails.add("tarun_penubarthi@gmail.com");
       emails.add("tarun-penubarthi@gmail.com");
       emails.add("@gmail.com");
       emails.add("tarun&gnail.com");
       emails.add("tarun#@gmail.me.org");
       emails.add("@tarun.gmail.com");

       Pattern pattern = Pattern.compile(regex);
       for (String value : emails) {
           Matcher matcher = pattern.matcher(value);

           System.out.println(value + " is " + (matcher.matches() ? "valid" : "invalid"));
       }
   }
}
