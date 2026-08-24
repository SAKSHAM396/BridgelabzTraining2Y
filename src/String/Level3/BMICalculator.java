package String.Level3;
import java.util.Scanner;
class BMICalculator{
    public static String getStatus(double bmi){
        if(bmi<18.5){
            return "Underweight";
        }else if(bmi<25){
            return "Normal";
        }else if(bmi<30){
            return "Overweight";
        }else{
            return "Obese";
        }
    }

    public static String[][] calculateBMI(double[][] data){
        String[][] result=new String[data.length][4];

        for(int i=0;i<data.length;i++){
            double weight=data[i][0];
            double height=data[i][1]/100;
            double bmi=weight/(height*height);

            result[i][0]=String.valueOf(data[i][1]);
            result[i][1]=String.valueOf(weight);
            result[i][2]=String.format("%.2f",bmi);
            result[i][3]=getStatus(bmi);
        }

        return result;
    }

    public static void display(String[][] result){
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

        for(int i=0;i<result.length;i++){
            System.out.println((i+1)+"\t"+result[i][0]+"\t"+result[i][1]+"\t"+result[i][2]+"\t"+result[i][3]);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        double[][] data=new double[10][2];

        for(int i=0;i<data.length;i++){
            System.out.print("Enter weight in kg for person "+(i+1)+": ");
            data[i][0]=input.nextDouble();

            System.out.print("Enter height in cm for person "+(i+1)+": ");
            data[i][1]=input.nextDouble();
        }

        String[][] result=calculateBMI(data);
        display(result);

        input.close();
    }
}