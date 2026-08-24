package Array.Level1;
import java.util.Scanner;
class OddEvenArray{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number=input.nextInt();
        if(number<=0){
            System.out.println("Invalid Number. Enter a natural number.");
            System.exit(0);
        }
        int[] even=new int[number/2+1];
        int[] odd=new int[number/2+1];
        int evenIndex=0;
        int oddIndex=0;
        for(int i=1;i<=number;i++){
            if(i%2==0){
                even[evenIndex]=i;
                evenIndex++;
            }else{
                odd[oddIndex]=i;
                oddIndex++;
            }
        }
        System.out.println("\nOdd Numbers:");
        for(int i=0;i<oddIndex;i++){
            System.out.print(odd[i]+" ");
        }
        System.out.println("\n\nEven Numbers:");
        for(int i=0;i<evenIndex;i++){
            System.out.print(even[i]+" ");
        }
        input.close();
    }
}