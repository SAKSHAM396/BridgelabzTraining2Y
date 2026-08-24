package Array.Level1;
import java.util.Scanner;
class StoreNumbers{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        double[] numbers=new double[10];
        int index=0;
        while(true){
            if(index==numbers.length){
                break;
            }
            System.out.print("Enter a positive number: ");
            double number=input.nextDouble();
            if(number<=0){
                break;
            }
            numbers[index]=number;
            index++;
        }
        double total=0.0;
        for(int i=0;i<index;i++){
            total+=numbers[i];
        }
        System.out.println("\nNumbers entered:");
        for(int i=0;i<index;i++){
            System.out.println(numbers[i]);
        }
        System.out.println("Total = "+total);
        input.close();
    }
}