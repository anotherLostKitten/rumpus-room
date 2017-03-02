/*
Jack Cruse
APCS1 pd4
HW47 -- Keep Guessing
2016-12-15
*/

import cs1.Keyboard;
import java.lang.Math;

public class GuessNumber {
    private int turns;//record turn #s
    private int low;//current min
    private int high;//current max
    private int ans;//store ans
    private int guess;//use for user input

    public GuessNumber() {
	turns = 0;//turns is 0 at start
	low = 1;//min is 1
	high = 100;//max is 100
	ans = ((int)((Math.random() * 99) + 0.5)) + 1;//random ans
	guess = 0;//no guess first
    }

    public void playTurn() {
	System.out.print("Guess a number from " +
        low + "-" + high + ": ");
	guess = Keyboard.readInt();//store user input
	//for guess

	turns += 1;//increment turns

	if (guess < low || guess > high) {//if your guess is absurd
	    System.out.println("Stop playing my game " +
			       "you troll");
	    return;
	    //I might have been the one that
	    //sabotaged the class game as a joke 
	    //but none of that is going to happen
	    //in my game
	}

	if (guess > ans) {//guess too high
	    System.out.println("Too high, try again...");
	    high = guess - 1;//set new max
	    this.playTurn();//play again
	}

	else if (guess < ans) {//guess too low
	    System.out.println("Too low, try again...");
	    low = guess + 1;//set new min
	    this.playTurn();//play again
	}

	else {//you win
	    System.out.println("Correct! It took " +
			       turns + " guesses");
	}
    }//end turn

    public static void main( String[] args ) {
	GuessNumber jack = new GuessNumber();//new game
	
	System.out.println("New GuessNumber game!\n");//nice formatting message
	
	jack.playTurn();//play until won
    }//end main
}//end GuessNumber
