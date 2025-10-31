package Java_Practice;

public class IfElseConditions {

	public static void main(String[] args) {
		
		// Define a integer array
		// Write a logic and print the number divide by 2
		
		int[] Arry = {1,2,3,4,5,6,7,8,9,10,20,40};
		
		for (int i=0; i<Arry.length; i++)
		{
           if(Arry[i] % 2 == 0)
             {
        	   System.out.println(Arry[i] + " - Multiple with 2.");
        	   break;
        	   
	         }
           else
           {
        	   
        	   System.out.println(Arry[i]+ " - This number is not multiple with 2.");
           }
			
		}

	}

}
