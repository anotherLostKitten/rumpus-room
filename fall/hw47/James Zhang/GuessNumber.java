/* James Zhang
APCS1 pd4
HW #47: Keep Guessing
2016-12-18   */
import cs1.Keyboard;

public class GuessNumber{

    private static int rng;
    private static int attemptNum;
    private static int userInput;
    private static int upperBound;
    private static int lowerBound;

    public GuessNumber(){
	rng =(int)( Math.random()*100); //generates random int from 0-100
	attemptNum = 1;
	userInput = 0;
	upperBound = 100;
	lowerBound = 0;
    }

    public static void setBounds(int lower, int upper){
	lowerBound = lower;
	upperBound = upper;
    }
    public static int getUpperBound(){
	return upperBound;
    }
    public static int getLowerBound(){
	return lowerBound;
    }
    public static int getAttemptNum(){
	return attemptNum;
    }

    //sees how input compares with rng
    public static int compare(int input){
	userInput = input;
	int swag = 0;
        if (userInput == rng){
	    swag = 0;
	}
	if (userInput > rng){
	    swag = 1;
	}
	if (userInput < rng){
	    swag = -1;
	}
	return swag;
    }


    //recursive method
    public static void playTurn(){

	System.out.println("guess a number from " + getUpperBound() +
			   " - " + getLowerBound() + ":");
	int input = Keyboard.readInt();

	compare(input);
	    
	if (compare(input) == 1  || compare(input) == -1){
	    if(compare(input) == 1){
		System.out.println("too high");
		setBounds(lowerBound, input);
	    }
	    if(compare(input) == -1){
		System.out.println("too low");
		setBounds(input, upperBound);
	    }
	    System.out.println("try again...");
	    attemptNum++;
	    playTurn();
	}

	    
	System.out.println("you got it! it took " + getAttemptNum() + " tries!");

    }
    
    public static void main(String[] args) {

	System.out.println("heyo wanna play this number guessing game?");
	System.out.println(" type 'yes' or 'no' ");

	String answer = Keyboard.readWord();

	if (answer.equals("yes")){
	    GuessNumber n = new GuessNumber();
	    playTurn();
	}

	if (answer.equals("no")){
	    System.out.println("then why'd you java this?");
	}
	
    }


    
}
