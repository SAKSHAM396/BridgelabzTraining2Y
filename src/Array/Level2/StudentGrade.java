package Array.Level2;
import java.util.Scanner;
class StudentGrade{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number=input.nextInt();

        double[][] marks=new double[number][3];
        double[] percentage=new double[number];
        char[] grade=new char[number];

        for(int i=0;i<number;i++){
            while(true){
                System.out.print("Enter Physics marks: ");
                marks[i][0]=input.nextDouble();

                System.out.print("Enter Chemistry marks: ");
                marks[i][1]=input.nextDouble();

                System.out.print("Enter Maths marks: ");
                marks[i][2]=input.nextDouble();

                if(marks[i][0]<0||marks[i][1]<0||marks[i][2]<0){
                    System.out.println("Invalid marks. Enter positive values.");
                }else{
                    break;
                }
            }
        }

        for(int i=0;i<number;i++){
            percentage[i]=(marks[i][0]+marks[i][1]+marks[i][2])/3;

            if(percentage[i]>=80){
                grade[i]='A';
            }else if(percentage[i]>=70){
                grade[i]='B';
            }else if(percentage[i]>=60){
                grade[i]='C';
            }else if(percentage[i]>=50){
                grade[i]='D';
            }else if(percentage[i]>=40){
                grade[i]='E';
            }else{
                grade[i]='R';
            }
        }

        for(int i=0;i<number;i++){
            System.out.println("Student "+(i+1));
            System.out.println("Physics = "+marks[i][0]);
            System.out.println("Chemistry = "+marks[i][1]);
            System.out.println("Maths = "+marks[i][2]);
            System.out.println("Percentage = "+percentage[i]);
            System.out.println("Grade = "+grade[i]);
        }

        input.close();
    }
}