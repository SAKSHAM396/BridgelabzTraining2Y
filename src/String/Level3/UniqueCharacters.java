package String.Level3;
import java.util.Scanner;
class UniqueCharacters{
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

    public static char[] findUniqueCharacters(String text){
        int length=findLength(text);
        char[] temp=new char[length];
        int count=0;

        for(int i=0;i<length;i++){
            boolean found=false;

            for(int j=0;j<i;j++){
                if(text.charAt(i)==text.charAt(j)){
                    found=true;
                    break;
                }
            }

            if(!found){
                temp[count]=text.charAt(i);
                count++;
            }
        }

        char[] result=new char[count];

        for(int i=0;i<count;i++){
            result[i]=temp[i];
        }

        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text=input.nextLine();

        char[] result=findUniqueCharacters(text);

        System.out.print("Unique Characters: ");

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

        input.close();
    }
}