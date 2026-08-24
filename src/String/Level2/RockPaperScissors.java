package String.Level2;
import java.util.Scanner;
class RockPaperScissors{
    public static String computerChoice(){
        int choice=(int)(Math.random()*3);

        if(choice==0){
            return "Rock";
        }else if(choice==1){
            return "Paper";
        }

        return "Scissors";
    }

    public static String findWinner(String user,String computer){
        if(user.equals(computer)){
            return "Draw";
        }

        if((user.equals("Rock")&&computer.equals("Scissors"))||
                (user.equals("Paper")&&computer.equals("Rock"))||
                (user.equals("Scissors")&&computer.equals("Paper"))){
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins,int computerWins,int draws,int games){
        String[][] result=new String[3][3];

        result[0][0]="Player";
        result[0][1]=String.valueOf(playerWins);
        result[0][2]=String.valueOf(Math.round((playerWins*100.0/games)*100.0)/100.0);

        result[1][0]="Computer";
        result[1][1]=String.valueOf(computerWins);
        result[1][2]=String.valueOf(Math.round((computerWins*100.0/games)*100.0)/100.0);

        result[2][0]="Draw";
        result[2][1]=String.valueOf(draws);
        result[2][2]=String.valueOf(Math.round((draws*100.0/games)*100.0)/100.0);

        return result;
    }

    public static void displayStats(String[][] stats){
        System.out.println("\nPlayer\tWins\tPercentage");

        for(int i=0;i<stats.length;i++){
            System.out.println(stats[i][0]+"\t"+stats[i][1]+"\t"+stats[i][2]+"%");
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games=input.nextInt();

        int playerWins=0;
        int computerWins=0;
        int draws=0;

        for(int i=1;i<=games;i++){
            System.out.print("Enter Rock, Paper or Scissors: ");
            String user=input.next();

            user=user.substring(0,1).toUpperCase()+user.substring(1).toLowerCase();

            if(!user.equals("Rock")&&!user.equals("Paper")&&!user.equals("Scissors")){
                System.out.println("Invalid choice.");
                i--;
                continue;
            }

            String computer=computerChoice();
            String winner=findWinner(user,computer);

            if(winner.equals("Player")){
                playerWins++;
            }else if(winner.equals("Computer")){
                computerWins++;
            }else{
                draws++;
            }

            System.out.println("Game "+i+": Player = "+user+", Computer = "+computer+", Winner = "+winner);
        }

        String[][] stats=calculateStats(playerWins,computerWins,draws,games);
        displayStats(stats);

        input.close();
    }
}