import java.util.Scanner;
class CalculateSimpleInterest{
	public static void main(String []args){
		Scanner am=new Scanner(System.in);
		System.out.println("Enter the principal");
		float principal=am.nextFloat();
		System.out.println("Enter the rate");
		float rate=am.nextFloat();
		System.out.println("Enter the time");
		float time=am.nextFloat();
		float SimpleInterest=(principal*rate*time)/100;
		System.out.println(SimpleInterest);
	}
}
