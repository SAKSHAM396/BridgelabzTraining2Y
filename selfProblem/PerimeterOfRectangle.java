import java.util.Scanner;
class PerimeterOfRectangle{
	public static void main(String [] args){
		Scanner am=new Scanner(System.in);
		System.out.println("Enter the length:");
		float length =am.nextFloat();
		System.out.println("Enter the width:");
		float width=am.nextFloat();
		float perimeter =2*(length+width);
		System.out.println(perimeter);
	}
}