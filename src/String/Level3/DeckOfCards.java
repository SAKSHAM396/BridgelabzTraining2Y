package String.Level3;
import java.util.Scanner;
class DeckOfCards{
    public static String[] initializeDeck(String[] suits,String[] ranks){
        String[] deck=new String[suits.length*ranks.length];
        int index=0;

        for(int i=0;i<suits.length;i++){
            for(int j=0;j<ranks.length;j++){
                deck[index]=ranks[j]+" of "+suits[i];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck){
        for(int i=0;i<deck.length;i++){
            int randomCardNumber=i+(int)(Math.random()*(deck.length-i));

            String temp=deck[i];
            deck[i]=deck[randomCardNumber];
            deck[randomCardNumber]=temp;
        }

        return deck;
    }

    public static String[][] distributeCards(String[] deck,int players){
        if(deck.length%players!=0){
            return null;
        }

        int cardsPerPlayer=deck.length/players;
        String[][] result=new String[players][cardsPerPlayer];

        int index=0;

        for(int i=0;i<players;i++){
            for(int j=0;j<cardsPerPlayer;j++){
                result[i][j]=deck[index];
                index++;
            }
        }

        return result;
    }

    public static void displayPlayers(String[][] players){
        for(int i=0;i<players.length;i++){
            System.out.println("Player "+(i+1)+":");

            for(int j=0;j<players[i].length;j++){
                System.out.println(players[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        String[] suits={
                "Hearts","Diamonds","Clubs","Spades"
        };

        String[] ranks={
                "2","3","4","5","6","7","8","9","10",
                "Jack","Queen","King","Ace"
        };

        System.out.print("Enter number of players: ");
        int players=input.nextInt();

        String[] deck=initializeDeck(suits,ranks);
        shuffleDeck(deck);

        if(players<=0||deck.length%players!=0){
            System.out.println("Cards cannot be equally distributed among players.");
            input.close();
            return;
        }

        String[][] result=distributeCards(deck,players);

        displayPlayers(result);

        input.close();
    }
}