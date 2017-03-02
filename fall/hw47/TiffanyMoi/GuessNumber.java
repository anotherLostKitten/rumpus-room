//Tiffany Moi
//APCS1 pd5
//HW47 -- Keep Guessing
//2016-12-17

import cs1.Keyboard;
public class GuessNumber{
    private int num;
    public int upper;
    public int lower;
    public int count;

    public GuessNumber(){
	num = (int) (Math.random() * 100); //gives a random number 1-100
	upper = 100; //keeps track of the upper bound
	lower = 1; //keeps track of the lower bound
	count = 0; //keeps track of the number of guesses
    }
/*============================================
  Guess Method
  Prints out messages that tell you if the guess was too high or too low
  Returns whether or not your guess matches the target number
  ============================================*/
    public boolean guess(int a){
	count += 1;
	if (a > num){
	    System.out.println("Too high, try again\n");
	    upper = a;
	    return false;
	}
	else if (a < num){
	    System.out.println("Too low, try again\n");
	    lower = a;
	    return false;
	}
	return true;	    	  
    }
/*============================================
  Iterative Approach
  Continues to prompt the player to guess until the input matches the number
  Uses a while loop
  ============================================*/
    public void runGameI(){ 
	System.out.print("Guess a number from " + lower + "-" + upper + ": ");
	while (! guess(Keyboard.readInt())){
	    System.out.print("Guess a number from " + lower + "-" + upper + ": ");
	}
	System.out.println("Correct! It took " + count + " guesses.");
    }
/*============================================
  Recursive Approach
  Continues to prompt the player to guess until the input matches the number
  Makes calls to itself until the player makes the correct guess
  ============================================*/
    public void runGameR(){
	System.out.print("Guess a number from " + lower + "-" + upper + ": ");
	if (guess(Keyboard.readInt())){
	    System.out.println("Correct! It took " + count + " guesses.");
	}
	else{
	    runGameR();
	}
    }

    public static void main(String[] args){
	GuessNumber bob = new GuessNumber();
	System.out.println("Welcome to the Guessing game!! \n\n");
	bob.runGameR();

    }
}
    
