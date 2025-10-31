package Java_Practice;
import java.io.*;
import java.util.Scanner;

public class REVERSE_STARING {

	public static void main(String[] args) 
	{
		String OriginalString = "VIKAS";
		String ReverseString = "";
		
		// First Way To Reverse Staring
		
		
		  for (int i = 0; i<OriginalString.length(); i++) 
		  { 
		  ReverseString = OriginalString.charAt(i) + ReverseString;
		  
		  System.out.println("Reverse String is:" + ReverseString);
		  
		  }
		 

		
		// Second Way to Print reverse String
		
		/*
		 * for (int i =OriginalString.length()-1; i>=0; i-- ) {
		 * 
		 * System.out.println("Reverse Sting is : " + OriginalString.charAt(i)); }
		 */
		
		
	}

}
