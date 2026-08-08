import java.util.Scanner;
public class AreaOfCircle {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the radius");
        double n=sc.nextDouble();
        double area=3.14*n*n;
        System.out.print("Area:"+area);
    }
}
