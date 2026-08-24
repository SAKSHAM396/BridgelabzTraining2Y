package Array.Level1;
import java.util.Scanner;
class FizzBuzzArray{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number=input.nextInt();
        if(number<=0){
            System.out.println("Invalid Number.");
            input.close();
            return;
        }
        String[] result=new String[number+1];
        for(int i=0;i<=number;i++){
            if(i%3==0&&i%5==0){
                result[i]="FizzBuzz";
            }else if(i%3==0){
                result[i]="Fizz";
            }else if(i%5==0){
                result[i]="Buzz";
            }else{
                result[i]=String.valueOf(i);
            }
        }
        for(int i=0;i<result.length;i++){
            System.out.println("Position "+(i+1)+" = "+result[i]);
        }
        input.close();
    }
}