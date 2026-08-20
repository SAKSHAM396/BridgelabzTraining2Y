package SubmissionofIntroductiontoDataStructuresandAlgorithms.Section1PseudocodeProblems;
import java.util.Scanner;
public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER YOUR NUMBER: ");
        int t=sc.nextInt();
        boolean isPrime=true;
        if(t<=1){
            isPrime=false;
        }else {
            for (int i = 2; i * i <= t; i++) {
                if (t % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if(isPrime){
            System.out.println("IT IS A PRIME NUMBER");
        }else{
            System.out.println("IT IS NOT A PRIME NUMBER");
        }
    }
}
