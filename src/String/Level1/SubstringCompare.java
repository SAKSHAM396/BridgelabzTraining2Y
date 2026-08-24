package String.Level1;
import java.util.Scanner;
class SubstringCompare{
    public static String createSubstring(String text,int start,int end){
        String result="";
        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }
        return result;
    }
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
        System.out.print("Enter a string: ");
        String text=input.next();
        System.out.print("Enter start index: ");
        int start=input.nextInt();
        System.out.print("Enter end index: ");
        int end=input.nextInt();

        String result1=createSubstring(text,start,end);
        String result2=text.substring(start,end);

        System.out.println("Using charAt(): "+result1);
        System.out.println("Using substring(): "+result2);
        System.out.println("Both results are same: "+compareStrings(result1,result2));

        input.close();
    }
}