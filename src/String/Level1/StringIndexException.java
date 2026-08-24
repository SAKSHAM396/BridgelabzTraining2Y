package String.Level1;
import java.util.Scanner;
class StringIndexException{
    public static void generateException(String text){
        System.out.println(text.charAt(text.length()));
    }
    public static void handleException(String text){
        try{
            System.out.println(text.charAt(text.length()));
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("StringIndexOutOfBoundsException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text=input.nextLine();

        handleException(text);

        input.close();
    }
}