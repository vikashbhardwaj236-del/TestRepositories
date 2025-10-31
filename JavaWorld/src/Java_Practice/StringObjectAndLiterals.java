package Java_Practice;

public class StringObjectAndLiterals {

	public static void main(String[] args) {
		// String is an Object 
		// Also String Literal
		// First Way to declare
		
		String s = "My name is Vikas";
		s.charAt(5);
		//System.out.println(s.charAt(5));
		
		//Second way to declare
		String s1 = new String ("Welcome");
		
		// Convert below string in Array
		
		String s3 = "My name Vikas";
		
		String[] splittedstring = s3.split("name");
		System.out.println(splittedstring[0]);
		System.out.println(splittedstring[1].trim());

	}

}
