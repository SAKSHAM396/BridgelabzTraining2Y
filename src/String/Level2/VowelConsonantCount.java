package String.Level2;
import java.util.Scanner;
class VowelConsonantCount{
    public static String checkCharacter(char ch){
        if(ch>='A'&&ch<='Z'){
            ch=(char)(ch+32);
        }

        if(ch>='a'&&ch<='z'){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return "Vowel";
            }
            return "Consonant";
        }

        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String text){
        int vowels=0;
        int consonants=0;

        for(int i=0;i<text.length();i++){
            String type=checkCharacter(text.charAt(i));

            if(type.equals("Vowel")){
                vowels++;
            }else if(type.equals("Consonant")){
                consonants++;
            }
        }

        return new int[]{vowels,consonants};
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=input.nextLine();

        int[] result=countVowelsConsonants(text);

        System.out.println("Vowels = "+result[0]);
        System.out.println("Consonants = "+result[1]);

        input.close();
    }
}