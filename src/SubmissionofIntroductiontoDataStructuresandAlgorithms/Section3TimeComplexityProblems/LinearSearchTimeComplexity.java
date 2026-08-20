package SubmissionofIntroductiontoDataStructuresandAlgorithms.Section3TimeComplexityProblems;
import java.util.Scanner;
public class LinearSearchTimeComplexity {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target1 = sc.nextInt();
        int target2 = sc.nextInt();
        int target3 = sc.nextInt();
        System.out.println(linearSearch(arr, target1));
        System.out.println(linearSearch(arr, target2));
        System.out.println(linearSearch(arr, target3));
        sc.close();
    }
}