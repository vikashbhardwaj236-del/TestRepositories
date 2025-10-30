package Day8_JavaBasicPrograms;
import java.util.Scanner;

public class ReverseNumberWithInputEntered {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        // Ask user to enter a number
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int reversed = 0;

	        // Reverse the number
	        while (number != 0) {
	            int digit = number % 10;       // Get the last digit
	            reversed = reversed * 10 + digit; // Append digit to reversed number
	            number /= 10;                  // Remove last digit
	        }

	        // Display the reversed number
	        System.out.println("Reversed number: " + reversed);

	        scanner.close();

	}

}
