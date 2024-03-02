
import java.util.Scanner;
public class NumberGame {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int chances = 5;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Hey you have about " + chances + " chances to win the game");

        while(playAgain){
            int rand = getrandN(1,100);
            boolean guess = false;
            for(int i=0 ; i<chances ; i++){
                 System.out.println("Chance " + (i+1) + " Enter your guess: ");
                 int user = sc.nextInt();
                 if(user == rand){
                    guess = true;
                    score += 1;
                    System.out.println("You Won it.");
                    break;
                 }
                 else if(user > rand){
                    System.out.println("Too High");
                 }
                 else{
                    System.out.println("Too Low");
                 }

            }

            if(guess == false){
                System.out.println("Sorry, you lost the chances. The number is :" + rand);
            }
            System.out.println("Do you want to play Again(y/n)");
            String pA = sc.next();
            playAgain = pA.equalsIgnoreCase("y");
        }

        System.out.println("Here is your Score " + score);
    }
    
        public static int getrandN(int min , int max){
            return (int)(Math.random()*(max-min+1)+min);

        }
    }

            
            
        
        


