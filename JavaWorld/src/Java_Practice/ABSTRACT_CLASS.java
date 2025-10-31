package Java_Practice;


abstract class Animal
{
	abstract public void walk();
	// no need to body of this method because of made it as abstract
}

class Hourse extends Animal
{
	public void walk()
	{
		System.out.println("Horse can walk on 4 legs");
	}
}

class Chicken extends Animal
{
	public void walk()
	{
		System.out.println("Chicken can walk on 2 legs");
	}
}


public class ABSTRACT_CLASS 
{

	public static void main(String[] args) 
	{
		Hourse hrs = new Hourse();
		hrs.walk();
		Chicken chk = new Chicken();
		chk.walk();
		//Animal anm = new Animal();
		//anm.walk();
		
	// Can not make object of abstract class
  
		
		
		

	}

}
