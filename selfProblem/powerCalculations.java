import java.util.Scanner;
class powerCalculations{
	public static void main(String args []){
		Scanner am=new Scanner(System.in);
		System.out.println("Enter the base value");
		int base =am.nextInt();
		System.out.println("Enter the exponent value");
		int exponent=am.nextInt();
		double result=Math.pow(base,exponent);
		System.out.println(result);
		
		
	}
}