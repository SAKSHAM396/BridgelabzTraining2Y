package Array.Level1;
import java.util.Scanner;
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int[] multiplicationResult = new int[10];
        for (int i = 1; i <= multiplicationResult.length; i++) {
            multiplicationResult[i - 1] = number * i;
        }
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResult[i]);
        }
        input.close();
    }
}