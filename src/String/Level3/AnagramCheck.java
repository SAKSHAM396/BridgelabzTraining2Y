package String.Level3;
import java.util.Scanner;
class AnagramCheck{
    public static boolean checkAnagram(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }

        int[] frequencyFirst=new int[256];
        int[] frequencySecond=new int[256];

        for(int i=0;i<first.length();i++){
            frequencyFirst[first.charAt(i)]++;
            frequencySecond[second.charAt(i)]++;
        }

        for(int i=0;i<256;i++){
            if(frequencyFirst[i]!=frequencySecond[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter first text: ");
        String first=input.nextLine();

        System.out.print("Enter second text: ");
        String second=input.nextLine();

        System.out.println("Anagram = "+checkAnagram(first,second));

        input.close();
    }
}