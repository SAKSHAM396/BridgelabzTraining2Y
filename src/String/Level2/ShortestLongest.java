package String.Level2;
import java.util.Scanner;
class ShortestLongest{
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

    public static int[] findShortestLongest(String[][] data){
        int shortest=0;
        int longest=0;

        for(int i=1;i<data.length;i++){
            int current=Integer.parseInt(data[i][1]);
            int shortLength=Integer.parseInt(data[shortest][1]);
            int longLength=Integer.parseInt(data[longest][1]);

            if(current<shortLength){
                shortest=i;
            }

            if(current>longLength){
                longest=i;
            }
        }

        return new int[]{shortest,longest};
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=input.nextLine();

        String[] words=splitText(text);
        String[][] data=wordLengthArray(words);
        int[] result=findShortestLongest(data);

        System.out.println("Shortest Word = "+data[result[0]][0]);
        System.out.println("Shortest Length = "+data[result[0]][1]);
        System.out.println("Longest Word = "+data[result[1]][0]);
        System.out.println("Longest Length = "+data[result[1]][1]);

        input.close();
    }
}