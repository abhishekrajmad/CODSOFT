import java.util.Random;
import java.util.Scanner;
public class Number {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int min=1;
        int max=100;
        int maxAttempts=15;
        int score=0;

    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("You need to guess a random number between " + min + " and " + max + ".");
    boolean hasGuessedcorrectly = false;
    do{
        int attempts=0;
        int n=r.nextInt(max-min+1)+min;

        System.out.println("Round " + (score + 1) + ":");
        while (attempts < maxAttempts) {
        System.out.println("Enter your guess:");
        int userGuess = s.nextInt();
        attempts++;
        if(userGuess < min || userGuess > max){
            System.out.println("Your guess is not in range. Try again!!");
            
           System.out.println("Attempts left:"+(maxAttempts-attempts));
        } else if (userGuess == n) {
            System.out.println("Perfect match buddy!!");
            hasGuessedcorrectly=true;
            break;            
        } else if (userGuess < n) {
           System.out.println("Your guess is too low"); 
           
           System.out.println("Attempts left:"+(maxAttempts-attempts));
        } else {
           System.out.println("Your guess is too high");
           
           System.out.println("Attempts left:"+(maxAttempts-attempts));
        }
        }
        System.out.println("You guessed the number in "+attempts+" Attempts");
    if (!hasGuessedcorrectly) {
        System.out.println("Out of attempts. The correct number is: " + n);
    }
    score++;
    System.out.println("Your current score: " + score);
    System.out.print("Do you want to play another round? (yes/no): ");
} while(s.next().equalsIgnoreCase("yes"));

System.out.println("Thank you for playing! Your final score: " + score);
s.close();
}
}
