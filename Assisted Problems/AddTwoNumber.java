import java.util.Scanner;
public class AddTwoNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number:");
        int n=sc.nextInt();
        System.out.print("enter the second number");
        int k=sc.nextInt();
        int sum=n+k;
        System.out.println(sum);
    }
}
