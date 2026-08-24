package String.Level2;
import java.util.Scanner;
class WordLength{
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

    public static String[] splitText(String text){
        int length=findLength(text);
        int words=1;

        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                words++;
            }
        }

        String[] result=new String[words];
        int start=0;
        int index=0;

        for(int i=0;i<length;i++){
            if(text.charAt(i)==' '){
                result[index]=substring(text,start,i);
                index++;
                start=i+1;
            }
        }

        result[index]=substring(text,start,length);
        return result;
    }

    public static String substring(String text,int start,int end){
        String result="";
        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }
        return result;
    }

    public static String[][] wordLengthArray(String[] words){
        String[][] result=new String[words.length][2];

        for(int i=0;i<words.length;i++){
            result[i][0]=words[i];
            result[i][1]=String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=input.nextLine();

        String[] words=splitText(text);
        String[][] result=wordLengthArray(words);

        System.out.println("Word\tLength");

        for(int i=0;i<result.length;i++){
            int length=Integer.parseInt(result[i][1]);
            System.out.println(result[i][0]+"\t"+length);
        }

        input.close();
    }
}