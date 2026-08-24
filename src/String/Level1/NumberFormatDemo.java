package String.Level1;
import java.util.Scanner;
class NumberFormatDemo{
    public static void generateException(String text){
        int number=Integer.parseInt(text);
        System.out.println(number);
    }
    public static void handleException(String text){
        try{
            int number=Integer.parseInt(text);
            System.out.println(number);
        }catch(NumberFormatException e){
            System.out.println("NumberFormatException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=input.nextLine();

        handleException(text);

        input.close();
    }
}