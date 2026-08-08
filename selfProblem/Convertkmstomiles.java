import java.util.Scanner;
class Convertkmstomiles{
	
	public static void main(String []args){
		Scanner am=new Scanner(System.in);
		System.out.println("enter kilometer");
		double kilometer=am.nextDouble();
		double miles=kilometer*0.621371;
		System.out.println(miles);
	}
}