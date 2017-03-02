// Eric Chen
// APCS1 pd3
// HW47 -- Keep Guessing
// 2016-12-15
import cs1.Keyboard;

public class GuessNumber {

    // Inst Vars
    private int number;     // The number to be guessed
    private int upper;      // The upper bound
    private int lower;      // The lower bound
    private int numGuesses; // The current number of guesses


    // Default Constructor
    public GuessNumber() {
	number = (int)( Math.random() * 100 ) + 1; // Adds 1 to make range 1-100 instead of 0-99
	upper = 100;
	lower = 1;
        numGuesses = 1;
    }

    // ACCESSORS
    public int getNumber() {
	return number;
    }

    public int getUpper() {
	return upper;
    }

    public int getLower() {
	return lower;
    }

    public int getNumGuesses() {
	return numGuesses;
    }

    // MUTATORS
    public int setUpper( int newUpper ) {
	int oldUpper = upper;
	upper = newUpper;
	return oldUpper;
    }
    
    public int setLower( int newLower ) {
	int oldLower = lower;
	lower = newLower;
	return oldLower;
    }

    // Mutator that increases numGuesses by 1
    public int takeTurn() {
    	int oldNG = numGuesses;
	numGuesses += 1;
	return oldNG;
    }

    public static void guess( GuessNumber gn ) {

	// Takes in the input, sets int x to input's value
      	System.out.println( "Guess No. " + gn.getNumGuesses() );
      	System.out.println( "Guess a number from " + gn.getLower() + "-" + gn.getUpper() + ": " );
	int x = Keyboard.readInt();

	// Checks to see if input is the correct number
	// Doesn't update numGuesses because it was guessed on that turn.
	if ( x == gn.getNumber() ) {
	    System.out.println( "=========================" ); // Divider for neatness
	    System.out.println( "Correct! You guessed the number in " + gn.getNumGuesses() + " tries!" );
	}
	
	// Checks whether to print "too high" or "too low"
	else {
	    gn.takeTurn(); // Updates numGuesses
	    System.out.println( "=========================" ); // Divider for neatness
	    // If too high
	    if ( x > gn.getNumber() ) {
		System.out.println( "Too high, try again..." );
		if ( x < gn.getUpper() ) gn.setUpper( x - 1 ); // Subtracting 1 makes lower bound included in range
	    }
	    // If too low
	    else {
		System.out.println( "Too low, try again..." );
		if ( x > gn.getLower() ) gn.setLower( x + 1 ); // Adding 1 makes upper bound included in range
	    }
	    
	    guess( gn ); // Recursion if not guessed
	    
	}

    }

    public static void main( String[] args ) {

	// Create new GuessNumber
        GuessNumber haha = new GuessNumber();

	// Initialization Message
	System.out.println( "==========================" );
	System.out.println( "     Guess The Number     " );
	System.out.println( "==========================" );

	// Start game
	guess( haha );
    }

}
