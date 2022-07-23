package ArithmeticCalculator;

import java.util.Scanner;

public class ArithmeticCalculator {
	   public static void main(String[] args)
	   {
	      float a, b, c;
	      int op;
	      try (Scanner scan = new Scanner(System.in)) {
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.print("Choose the Arithmetic Operation (1-4): ");
			op = scan.nextInt();  
			if(op>=1 && op<=4){
				System.out.print("\nEnter any Two Number: ");
				a = scan.nextFloat();
				b = scan.nextFloat();
				if(op==1)
					c = a+b;
				else if(op==2)
					c = a-b;
				else if(op==3)
					c = a*b;
				else
			        c = a/b;
				System.out.println("\nAnswer = " +c);
			  }
			else
				System.out.println("\nInvalid Choice!");
		}
	   } 	
	

}