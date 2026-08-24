package Array.Level2;
import java.util.Scanner;
class LargestSecondLargest{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number=input.nextInt();

        if(number<0){
            System.out.println("Invalid Number.");
            input.close();
            return;
        }

        int maxDigit=10;
        int[] digits=new int[maxDigit];
        int index=0;

        while(number!=0){
            if(index==maxDigit){
                break;
            }

            digits[index]=number%10;
            number/=10;
            index++;
        }

        int largest=0;
        int secondLargest=0;

        for(int i=0;i<index;i++){
            if(digits[i]>largest){
                secondLargest=largest;
                largest=digits[i];
            }else if(digits[i]>secondLargest&&digits[i]!=largest){
                secondLargest=digits[i];
            }
        }

        System.out.println("Largest = "+largest);
        System.out.println("Second Largest = "+secondLargest);

        input.close();
    }
}