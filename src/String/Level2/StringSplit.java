package String.Level2;
import java.util.Scanner;
class StringSplit{
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
                result[index]=createSubstring(text,start,i);
                index++;
                start=i+1;
            }
        }

        result[index]=createSubstring(text,start,length);
        return result;
    }

    public static String createSubstring(String text,int start,int end){
        String result="";
        for(int i=start;i<end;i++){
            result+=text.charAt(i);
        }
        return result;
    }

    public static boolean compareArrays(String[] a,String[] b){
        if(a.length!=b.length){
            return false;
        }

        for(int i=0;i<a.length;i++){
            if(!a[i].equals(b[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=input.nextLine();

        String[] result1=splitText(text);
        String[] result2=text.split(" ");

        System.out.println("User-defined split:");

        for(int i=0;i<result1.length;i++){
            System.out.println(result1[i]);
        }

        System.out.println("Built-in split:");

        for(int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }

        System.out.println("Both results are same: "+compareArrays(result1,result2));

        input.close();
    }
}