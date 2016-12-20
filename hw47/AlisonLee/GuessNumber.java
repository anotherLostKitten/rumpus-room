// Alison Lee
// APCS1 pd5
// HW47 -- Keep Guessing
// 2016-12-18

import cs1.Keyboard ; 

public class GuessNumber {
	
    private int lowerBound = 1 ; 
    private int upperBound = 100 ;    
    private int uI ; // userInput
	private int numTries = 0 ; // number of guesses
	private int target = ( int )( Math.random() * 100 ) + 1 ;
	
	public void playR() {
		System.out.println( "Guess a number from " + lowerBound + " to " + upperBound + ":" ) ;
		uI = Keyboard.readInt() ;
		numTries += 1 ;
		
		if( uI != target ) {
			if ( uI > target ) {
				// if the input is lower than the existing upperBound, then the upperBound is set to the input. This is so that the guessing range gets smaller and closer to the target.
				if( uI < upperBound ) { // while the input doesn't match the target
					upperBound = uI ;
				}
				System.out.println( "Too high. Try again... " ) ; 
			}
			else {// uI < target 
				// if the input is greater than the existing lowerBound, then the lowerBound is set to the input
				if( uI > lowerBound ) {
					lowerBound = uI ;
				}
				System.out.println( "Too low. Try again... " ) ;
			}
			playR() ;
		}
		
		else { // matches
			System.out.println( "Correct! It took " + numTries + " guesses." ) ;
		}
	}
	
	public void playI() {
		System.out.println( "Guess a number from " + lowerBound + " to " + upperBound + ":" ) ;
		uI = Keyboard.readInt() ;
		numTries += 1 ;
		while( uI != target ) { // while the input doesn't match the target
			if( uI > target ) {
				// if the input is lower than the existing upperBound, then the upperBound is set to the input. This is so that the guessing range gets smaller and closer to the target.
				if( uI < upperBound ) {
					upperBound = uI ;
				}
				System.out.println( "Too high. Try again... \nGuess a number from " + lowerBound + " to " + upperBound ) ;
			}
			else { // uI < target 
				// if the input is greater than the existing lowerBound, then the lowerBound is set to the input
				if( uI > lowerBound ) {
					lowerBound = uI ;
				} 
				System.out.println( "Too low. Try again... \nGuess a number from " + lowerBound + " to " + upperBound ) ;
			}
			uI = Keyboard.readInt() ;
			numTries += 1 ;
		}
		// it finally matches!
		System.out.println( "Correct! It took " + numTries + " guesses." ) ;
	}
	
    public static void main( String[] args ) {
		GuessNumber game = new GuessNumber() ;
		game.playR() ;
        // game.playI() ;
    }
}
