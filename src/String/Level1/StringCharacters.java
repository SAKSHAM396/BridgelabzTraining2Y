package String.Level1;
import java.util.Scanner;
class StringCharacters{
    public static char[] getCharacters(String text){
        char[] result=new char[text.length()];
        for(int i=0;i<text.length();i++){
            result[i]=text.charAt(i);
        }
        return result;
    }
    public static boolean compareArrays(char[] a,char[] b){
        if(a.length!=b.length){
            return false;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text=input.next();

        char[] result1=getCharacters(text);
        char[] result2=text.toCharArray();

        System.out.print("User-defined method: ");
        for(int i=0;i<result1.length;i++){
            System.out.print(result1[i]+" ");
        }

        System.out.print("\ntoCharArray(): ");
        for(int i=0;i<result2.length;i++){
            System.out.print(result2[i]+" ");
        }

        System.out.println("\nBoth arrays are same: "+compareArrays(result1,result2));

        input.close();
    }
}