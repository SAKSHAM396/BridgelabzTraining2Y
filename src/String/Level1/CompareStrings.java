package String.Level1;
import java.util.Scanner;
class CompareStrings{
    public static boolean compareStrings(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1=input.next();
        System.out.print("Enter second string: ");
        String s2=input.next();

        boolean result1=compareStrings(s1,s2);
        boolean result2=s1.equals(s2);

        System.out.println("Using charAt(): "+result1);
        System.out.println("Using equals(): "+result2);
        System.out.println("Both results are same: "+(result1==result2));

        input.close();
    }
}