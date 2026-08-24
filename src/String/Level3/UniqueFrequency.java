package String.Level3;
import java.util.Scanner;
class UniqueFrequency{
    public static char[] findUniqueCharacters(String text){
        char[] temp=new char[text.length()];
        int count=0;

        for(int i=0;i<text.length();i++){
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

    public static String[][] findFrequency(String text,char[] unique){
        String[][] result=new String[unique.length][2];

        for(int i=0;i<unique.length;i++){
            int count=0;

            for(int j=0;j<text.length();j++){
                if(text.charAt(j)==unique[i]){
                    count++;
                }
            }

            result[i][0]=String.valueOf(unique[i]);
            result[i][1]=String.valueOf(count);
        }

        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text=input.nextLine();

        char[] unique=findUniqueCharacters(text);
        String[][] result=findFrequency(text,unique);

        System.out.println("Character\tFrequency");

        for(int i=0;i<result.length;i++){
            System.out.println(result[i][0]+"\t\t"+result[i][1]);
        }

        input.close();
    }
}