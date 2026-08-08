import java.util.Scanner;

class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner am = new Scanner(System.in);
        System.out.println("Enter the value of a:");
        int a = am.nextInt();
        System.out.println("Enter the value of b:");
        int b = am.nextInt();
        System.out.println("Enter the value of c:");
        int c = am.nextInt();
        int sum = a + b + c;
        float average = sum / 3.0f;
        System.out.println("Average = " + average);
    }
}

