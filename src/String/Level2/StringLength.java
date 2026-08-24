package String.Level2;
import java.util.Scanner;
class StringLength{
    public static int findLength(String text){
        int count=0;
        while(true){
            try{
                text.charAt(count);
                count++;
            }catch(RuntimeException e){
                break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text=input.next();

        int result=findLength(text);

        System.out.println("User-defined length = "+result);
        System.out.println("Built-in length = "+text.length());

        input.close();
    }
}