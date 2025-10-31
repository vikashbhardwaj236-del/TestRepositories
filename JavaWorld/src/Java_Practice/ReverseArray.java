package Java_Practice;

public class ReverseArray {

	public static void main(String[] args) {
		
		// First way to Initialize the array first
		int[] MyArray = new int[4];
		
		MyArray[0] = 1;
		MyArray[1] = 2;
		MyArray[2] = 3;
		MyArray[3] = 4;
		
		// Second way to Initialize the array first
		 int[] numbers = {1,2,3,4,5};
		
		//System.out.println("Calculate the total number of elements within the numbers array : " + numbers.length);
		
		/*
		 * for(int i=0; i<numbers.length; i++) { System.out.println("Original Array : "
		 * + numbers[i]);
		 * 
		 * }
		 */

		// Program to reverse Array NUmbers
		System.out.println("Array In Reverse Order");
		for(int i=numbers.length-1; i>=0; i--)
		{
			
			System.out.println("Reverse Array Is : " + numbers[i]);
		}
			
		
		
		
	}

}
