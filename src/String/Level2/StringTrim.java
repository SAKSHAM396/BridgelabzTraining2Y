package String.Level2;
import java.util.Scanner;
class StringTrim{
    public static int[] trimIndexes(String text){
        int start=0;
        int end=text.length()-1;

        while(start<text.length()&&text.charAt(start)==' '){
            start++;
        }

        while(end>=0&&text.charAt(end)==' '){
            end--;
        }

        return new int[]{start,end+1};
    }

    public static String createSubstring(String text,int start,int end){
        String result="";

        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }

        return result;
    }

    public static boolean compareStrings(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }

        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String text=input.nextLine();

        int[] indexes=trimIndexes(text);

        String result1=createSubstring(text,indexes[0],indexes[1]);
        String result2=text.trim();

        System.out.println("User-defined trim = ["+result1+"]");
        System.out.println("Built-in trim = ["+result2+"]");
        System.out.println("Both results are same: "+compareStrings(result1,result2));

        input.close();
    }
}