package Day8_JavaBasicPrograms;
import java.util.Scanner;

public class ReverseWithAnotherWay {

	public static void main(String[] args) {
		// Reverse through String builder
		// No loops, no math — just treat the number like a word (string).
        // StringBuilder.reverse() does the reversing for you.
		
	    Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an number here : ");
		
		String number = scanner.nextLine();
		
		//int number = 12345;
		String Reversed = new StringBuilder(number).reverse().toString();
		
		System.out.println("Revered Sting is : "+ Reversed);
		//scanner.close();
		

	}

}
