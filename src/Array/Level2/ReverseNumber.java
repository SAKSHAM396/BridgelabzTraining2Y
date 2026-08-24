package Array.Level2;
import java.util.Scanner;
class ReverseNumber{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number=input.nextInt();

        if(number<0){
            System.out.println("Invalid Number.");
            input.close();
            return;
        }

        int temp=number;
        int count=0;

        if(number==0){
            count=1;
        }else{
            while(temp!=0){
                count++;
                temp/=10;
            }
        }

        int[] digits=new int[count];
        temp=number;

        for(int i=0;i<count;i++){
            digits[i]=temp%10;
            temp/=10;
        }

        int[] reverse=new int[count];

        for(int i=0;i<count;i++){
            reverse[i]=digits[count-1-i];
        }

        System.out.print("Reversed Number = ");

        for(int i=0;i<reverse.length;i++){
            System.out.print(reverse[i]);
        }

        input.close();
    }
}