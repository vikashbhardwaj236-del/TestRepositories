package Day8_JavaBasicPrograms;

public class PalindromeNumbers {

	public static void main(String[] args) {

int num = 12321;
int temp = num;
int reminder =0;
int reverse = 0;

while (num>0)
{
reminder= num%10;
reverse = reverse*10 + reminder;
num = num/10;

}
System.out.println("Revered Numbers : "+reverse);

if (temp == reverse)
{
	System.out.println("This is the Palindrome Numbers");
	
}
else
{
System.out.println("This is not the Palindrome Numbers");	
}



	}

}
