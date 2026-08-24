package String.Level3;
import java.util.Scanner;
class NestedFrequency{
    public static String[] findFrequency(String text){
        char[] characters=text.toCharArray();
        int[] frequency=new int[characters.length];

        for(int i=0;i<characters.length;i++){
            if(characters[i]=='0'){
                continue;
            }

            frequency[i]=1;

            for(int j=i+1;j<characters.length;j++){
                if(characters[i]==characters[j]){
                    frequency[i]++;
                    characters[j]='0';
                }
            }
        }

        int count=0;

        for(int i=0;i<characters.length;i++){
            if(characters[i]!='0'){
                count++;
            }
        }

        String[] result=new String[count];
        int index=0;

        for(int i=0;i<characters.length;i++){
            if(characters[i]!='0'){
                result[index]=characters[i]+" = "+frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text=input.nextLine();

        String[] result=findFrequency(text);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        input.close();
    }
}