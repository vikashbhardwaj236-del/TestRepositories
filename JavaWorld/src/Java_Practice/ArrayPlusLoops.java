package Java_Practice;
import java.util.ArrayList;


public class ArrayPlusLoops {

	public static void main(String[] args) {
		// Define array
		
		int[] arry = new int[5];
		arry[0] = 1;
		arry[1] = 3;
		arry[2] = 5;
		arry[3] = 7;
		arry[4] = 10;		
		
//		System.out.println(arry[4] + arry[3]);
		
		// Second way how we can define Arrey
		
		int[] Arry2 = {1,2,3,4,5,6,};
		
	//	System.out.println(Arry2[4]);
		
		/*
		 * for(int i = 0; i<Arry2.length; i++) {
		 * 
		 * System.out.println("Output is :" + Arry2[i]); }
		 */
		
		
		// Define String Array

		String[] arry3 = {"Vikas","Anchal","Vivan","Avika"};
		
		for (int i=0; i<arry3.length; i++)
		{
			
			System.out.println("String Output Is :"+ arry3[i]);
			
		}
		
		
		// Another way to define for loop an call string Array
		
		String[] arry4 = {"Shripal","KrishanPal","ShukhPal","DevPal"};
		
		
		for (String s: arry4)
		{
			System.out.println("Second way to loop : family names - "+ s);
			
		}
		
		// Define Array List
		
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("TATA");
	    System.out.println(cars);

		
		
	}
	
	
	}
