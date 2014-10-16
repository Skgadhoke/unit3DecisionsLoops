import java.util.Scanner;
public class RockPaperScissors2
{
    public static void main(String[] args)
        {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose rock, scissors, or paper:");
        String player1 = scan.next().toLowerCase();
        System.out.println("Player 2: Choose rock, scissors, or paper:");
        String player2 = scan.next().toLowerCase();
        if (player1.equals(player2))
            {
            System.out.println("Tie");
            }
            else if (player1.equals("rock") && player2.equals("paper"))
            {
            System.out.println("Paper wins");
            }
            else if (player1.equals("rock")&& player2.equals("scissors"))
            {
            System.out.println("Rock wins");
            }
            else if (player1.equals("paper") && player2.equals("rock"))
            {
            System.out.println("paper wins");
            }
            else if (player1.equals("paper") && player2.equals("scissors"))
            {
            System.out.println("Scissors wins");
            }
            else if (player1.equals("scissors") && player2.equals("rock"))
            {
            System.out.println("Rock wins");
            }
            else if(player1.equals("scissors") && player2.equals("paper"))
            {
            System.out.println("Scissors");
            }
            else
            {
            System.out.println("Invalid choice");
            }
            
            }
    }
    
    
    
    
    
