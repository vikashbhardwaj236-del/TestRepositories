package Java_Practice;
import java.util.ArrayList;

public class ArrayListTest {

	private static final String Break = null;

	public static void main(String[] args) {
		
		// Define the array list of String Type, first make object of it
		
		 ArrayList<Integer> arr2 = new ArrayList<Integer>();
		 arr2.add(1);
		 arr2.add(7);
		 arr2.add(67);
		 System.out.println("Array Result : "+ arr2);
		 System.out.println("Value of index 1 is : " + arr2.get(1));
		 
		 System.out.println();
		 
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Maruti");
	    cars.add("TATA");
	   // System.out.println("String Array Result : " + cars);
	   // System.out.println("Value of last index : " + cars.get(4));
	    System.out.println(cars.contains("TATA"));
	    System.out.println("*************************");
	    
	    for (int i = 0; i<cars.size();i++)
	    {
	    	System.out.println(cars.get(i));
	    	
	    	
	    }

	    
	    
	   
	    
	    
	    
	}

	

}
