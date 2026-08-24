package Array.Level2;
import java.util.Scanner;
class BMI{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number=input.nextInt();

        double[] weight=new double[number];
        double[] height=new double[number];
        double[] bmi=new double[number];
        String[] status=new String[number];

        for(int i=0;i<number;i++){
            while(true){
                System.out.print("Enter weight in kg for person "+(i+1)+": ");
                weight[i]=input.nextDouble();

                System.out.print("Enter height in meters for person "+(i+1)+": ");
                height[i]=input.nextDouble();

                if(weight[i]<=0||height[i]<=0){
                    System.out.println("Invalid input. Enter positive values.");
                }else{
                    break;
                }
            }
        }

        for(int i=0;i<number;i++){
            bmi[i]=weight[i]/(height[i]*height[i]);

            if(bmi[i]>=40){
                status[i]="Obese";
            }else if(bmi[i]>=30){
                status[i]="Obese";
            }else if(bmi[i]>=25){
                status[i]="Overweight";
            }else if(bmi[i]>=18.5){
                status[i]="Normal";
            }else{
                status[i]="Underweight";
            }
        }

        for(int i=0;i<number;i++){
            System.out.println("Person "+(i+1));
            System.out.println("Height = "+height[i]);
            System.out.println("Weight = "+weight[i]);
            System.out.println("BMI = "+bmi[i]);
            System.out.println("Status = "+status[i]);
        }

        input.close();
    }
}