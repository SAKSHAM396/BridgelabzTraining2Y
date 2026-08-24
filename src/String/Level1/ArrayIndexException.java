package String.Level1;
import java.util.Scanner;
class ArrayIndexException{
    public static void generateException(String[] names){
        System.out.println(names[names.length]);
    }
    public static void handleException(String[] names){
        try{
            System.out.println(names[names.length]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        String[] names=new String[3];

        for(int i=0;i<names.length;i++){
            System.out.print("Enter name "+(i+1)+": ");
            names[i]=input.nextLine();
        }

        handleException(names);

        input.close();
    }
}