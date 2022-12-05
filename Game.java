import java.util.Scanner;
public class Game
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("welcome to the game: Guess the correct number.");
        System.out.println("Enter the number of players");
        int num_of_players = sc.nextInt(); 
        int score[] = new int [num_of_players];          //Array to record scores of each player
        String name[] = new String [num_of_players];     //Array to record names of each player
        System.out.println("Enter the name of the players");
        for(int k=0 ; k<num_of_players ; k++)
        {
            name[k]=sc.next();  
        }
        System.out.println("Choose the LEVEL");
        System.out.println("Type '1' for EASY : Guess number between 1 to 100");
        System.out.println("Type '2' for MEDIUM : Guess number between 1 to 1000");
        System.out.println("Type '3' for HARD : Guess number between 1 to 10000");
        int level_choice = sc.nextInt();
        int random_num = 0 ;
        int score_count=0;
        for(int k=0 ; k<num_of_players ; k++){
            if(level_choice == 1)
                random_num = (int)(Math.random()*100);  // Generating a random number between 1 and 100
            else if (level_choice == 2)
                random_num = (int)(Math.random()*1000);  // Generating a random number between 1 and 1000
            else if (level_choice == 3)
                random_num = (int)(Math.random()*10000);  // Generating a random number between 1 and 10000
            System.out.println(name[k]+"'s turn");            
            System.out.println("enter 1 to play the game and -1 to exit the game");
            int game_initiator = sc.nextInt();
            int guessed_num = 0;
            if(game_initiator != 1 && game_initiator != -1){
                System.out.println("wrong choice");
            }
            else if(game_initiator == 1){      // Game starts if player entered 1
                do{
                    System.out.println("guess the number or type -1 to exit the game");
                    guessed_num = sc.nextInt();
                    if(guessed_num == random_num){
                        System.out.println("Bingo! you guessed the correct number");
                        score_count++;
                        break;
                    }
                    else if(guessed_num > random_num){
                        System.out.println("your number is too large");
                        score_count++;
                    }
                    else {
                        System.out.println("your number is too less");
                        score_count++;
                    }
                }
                while(guessed_num != -1);     // checking if the player want to continue the game or not
            }
            if(guessed_num == -1)             // If player exits the game then his score will be 0;
                score[k]=0;
            else
                score[k] = score_count;
                score_count = 0;
        }
        System.out.println("______ScoreSheet______");
        for(int k=0 ; k<num_of_players ; k++){
            System.out.println(name[k] + ": " + score[k]);
        }
        int min_index = -1;
        int min_score = Integer.MAX_VALUE;
        for (int i = 0; i < num_of_players; i++){
            if(score[i]<min_score && score[i] != 0){    // Finding minimum number of attempts by the players
                min_score = score[i];
                min_index = i;
            }    
        }
        int same_scores_count = 0;
        for (int i = 0; i < num_of_players; i++){       // Checking if two players have same scores
            if (score[i] == min_score)
                same_scores_count++;
        }
        if (same_scores_count == 1)
        System.out.println("The winner is '" + name[min_index] + "' with least number of attempts " + score[min_index]);
        else
        System.out.println("Nobody Wins");
        sc.close();
    }
}

