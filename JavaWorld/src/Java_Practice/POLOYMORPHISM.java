package Java_Practice;


class Student
{
	String name;
	int age;
	
public void PrintInfo(String name)
{
	System.out.println(name);
}

public void PrintInfo(int age)
{
	System.out.println(age);
}
public void PrintInfo(String name,int age)
{
	System.out.println(name +" & "+ age);
}

}

public class POLOYMORPHISM {

	public static void main(String[] args) {
		Student st = new Student();
	st.name = "Vikas";
	st.age = 24;
	
	st.PrintInfo(st.name);
	st.PrintInfo(st.age);
	st.PrintInfo(st.name,st.age);
	
		
	}

}
