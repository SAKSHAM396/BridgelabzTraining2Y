package String.Level3;
import java.util.Scanner;
class PalindromeCheck{
    public static boolean checkUsingLoop(String text){
        int start=0;
        int end=text.length()-1;

        while(start<end){
            if(text.charAt(start)!=text.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean checkUsingRecursion(String text,int start,int end){
        if(start>=end){
            return true;
        }

        if(text.charAt(start)!=text.charAt(end)){
            return false;
        }

        return checkUsingRecursion(text,start+1,end-1);
    }

    public static String reverse(String text){
        String result="";

        for(int i=text.length()-1;i>=0;i--){
            result+=text.charAt(i);
        }

        return result;
    }

    public static boolean checkUsingArray(String text){
        char[] original=text.toCharArray();
        String reversedText=reverse(text);
        char[] reversed=reversedText.toCharArray();

        if(original.length!=reversed.length){
            return false;
        }

        for(int i=0;i<original.length;i++){
            if(original[i]!=reversed[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=input.nextLine();

        boolean result1=checkUsingLoop(text);
        boolean result2=checkUsingRecursion(text,0,text.length()-1);
        boolean result3=checkUsingArray(text);

        System.out.println("Using Loop = "+result1);
        System.out.println("Using Recursion = "+result2);
        System.out.println("Using Character Array = "+result3);

        input.close();
    }
}