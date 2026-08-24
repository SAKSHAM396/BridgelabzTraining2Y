package String.Level3;
import java.util.Scanner;
class CharacterFrequency{
    public static String[][] findFrequency(String text){
        int[] frequency=new int[256];

        for(int i=0;i<text.length();i++){
            frequency[text.charAt(i)]++;
        }

        int count=0;

        for(int i=0;i<frequency.length;i++){
            if(frequency[i]>0){
                count++;
            }
        }

        String[][] result=new String[count][2];
        int index=0;

        for(int i=0;i<frequency.length;i++){
            if(frequency[i]>0){
                result[index][0]=String.valueOf((char)i);
                result[index][1]=String.valueOf(frequency[i]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text=input.nextLine();

        String[][] result=findFrequency(text);

        System.out.println("Character\tFrequency");

        for(int i=0;i<result.length;i++){
            System.out.println(result[i][0]+"\t\t"+result[i][1]);
        }

        input.close();
    }
}