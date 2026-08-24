package String.Level1;
import java.util.Scanner;
class NullPointerDemo{
    public static void generateException(){
        String text=null;
        System.out.println(text.length());
    }
    public static void handleException(){
        String text=null;
        try{
            System.out.println(text.length());
        }catch(NullPointerException e){
            System.out.println("NullPointerException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text=input.nextLine();

        handleException();

        input.close();
    }
}