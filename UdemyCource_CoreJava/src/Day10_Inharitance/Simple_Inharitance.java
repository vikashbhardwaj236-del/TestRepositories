package Day10_Inharitance;

//Parent Class
class Animal
{
	void eat ()
	{
		
		System.out.println("Animal Can eat");
	}
}

//Child Class
class Dog extends Animal
{
void bark()
{
	System.out.println("Dog Can bark");
}
}

public class Simple_Inharitance 
{
	public static void main(String[] args) 
	{
	
		Dog obj = new Dog();
		obj.eat();
		obj.bark();
		
		
	}

}
