package Day7_LoopingAndJumping;

public class EnhancedForLoop {

	public static void main(String[] args) {
	int num = 12345;
	int Reminder = 0;
	int Reverse = 0;
	while (num>0)
	{
		
		Reminder = num%10;
		Reverse = Reverse*10 + Reminder;
		num = num/10;
		
	}
	System.out.println("Reverse Numbers : "+ Reverse);
	

	}

}
