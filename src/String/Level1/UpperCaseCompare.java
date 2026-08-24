package String.Level1;
import java.util.Scanner;
class UpperCaseCompare{
    public static String convertToUpperCase(String text){
        String result="";
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch>='a'&&ch<='z'){
                ch=(char)(ch-32);
            }
            result+=ch;
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
        System.out.print("Enter complete text: ");
        String text=input.nextLine();

        String result1=convertToUpperCase(text);
        String result2=text.toUpperCase();

        System.out.println("Using charAt(): "+result1);
        System.out.println("Using toUpperCase(): "+result2);
        System.out.println("Both results are same: "+compareStrings(result1,result2));

        input.close();
    }
}