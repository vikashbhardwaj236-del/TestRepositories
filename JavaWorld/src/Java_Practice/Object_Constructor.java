package Java_Practice;
import java.lang.Object;

class Pen
{
	String Color;
	String type;
	
	 public void Writing()
	{
		System.out.println("Need to write something.");
			
	}
	 
	 public void PenColor()
	 {
		 System.out.println(this.Color);
	 }
	 public void PenType()
	 {
		 System.out.println(this.type);
	 
	 }
	 Pen()
	 {
		 
		 System.out.println("This is the contructor Method");
		 
	 }

}
public class Object_Constructor 
{
	public static void main(String[] args) 
	{
		Pen Penobj = new Pen();
		Penobj.Color = "blue-1";
		Penobj.Writing();
    	Penobj.PenColor();
    	
    	Pen ob2 = new Pen();
    	ob2.Color = "Black";
    	ob2.type = "Ball Pen";
    	ob2.PenColor();
    	ob2.PenType();
    	
    	
		
	}

}

