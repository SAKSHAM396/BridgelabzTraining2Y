package Array.Level2;
import java.util.Scanner;
class BMI2D{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number=input.nextInt();

        double[][] personData=new double[number][3];
        String[] weightStatus=new String[number];

        for(int i=0;i<number;i++){
            while(true){
                System.out.print("Enter weight in kg: ");
                personData[i][0]=input.nextDouble();

                System.out.print("Enter height in meters: ");
                personData[i][1]=input.nextDouble();

                if(personData[i][0]<=0||personData[i][1]<=0){
                    System.out.println("Invalid input. Enter positive values.");
                }else{
                    break;
                }
            }
        }

        for(int i=0;i<number;i++){
            personData[i][2]=personData[i][0]/
                    (personData[i][1]*personData[i][1]);

            if(personData[i][2]>=30){
                weightStatus[i]="Obese";
            }else if(personData[i][2]>=25){
                weightStatus[i]="Overweight";
            }else if(personData[i][2]>=18.5){
                weightStatus[i]="Normal";
            }else{
                weightStatus[i]="Underweight";
            }
        }

        for(int i=0;i<number;i++){
            System.out.println("Person "+(i+1));
            System.out.println("Weight = "+personData[i][0]);
            System.out.println("Height = "+personData[i][1]);
            System.out.println("BMI = "+personData[i][2]);
            System.out.println("Status = "+weightStatus[i]);
        }

        input.close();
    }
}