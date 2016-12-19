//Xin Yi Chen
//APCS1 pd4
//HW47 -- Keep Guessing
//2016-12-19

/*Class GuessNumber:
  Upon each execution, randomly select a number between 1 and 100 (inclusive),and then create a user dialogue. 
  It should be able to run a game of Guess-a-Number via iteration or recursion.
 */

/* in addition:
   1. user can choose to continue playing the game after each round
   2. stores best record/ lowest number of tries
   3. user can choose the upper limit
*/


import cs1.Keyboard;

public class GuessNumber{
    
    private int num;
    private int ctr;
    private int upLim;
    private int lowLim;
    private String message = ""; //whether the input is correct or too low or too high
    private int bestTry;

    public GuessNumber()
    {
	ctr = 0;
	upLim = 100;
	lowLim = 1;
	bestTry = 1000000;
    }

    //sets the message base on whether the user guess the right number or not
    //changes upLim and lowLim
    public boolean lowOrHigh( int a )
    {
	ctr += 1;
	if (a > num){
	    upLim = a;
	    message = "Too high, try again...";
	    return false;
	}
	else if( a < num){
	    lowLim = a;
	    message = "Too low, try again...";
	    return false;
	}
	else{
	    message = "YAY YOU GOT IT!!!!!!! IT TOOK " + ctr + " guesses!";
	    return true;
	}
    }

    public static void main (String [] args)
    {
	GuessNumber me = new GuessNumber();

	int stop = 1; //1:continues; 2:stops the game

	System.out.println("Choose a number from 1 to 2147483647 as your upper limit: ");
	me.upLim = Keyboard.readInt();

	//if the user input something out of range: upLim is set to 100
	if (me.upLim < 0){
	    System.out.println("Your choosen number is out of range. Your upper limit is set to 100");
	    me.upLim = 100;
	}

	int temp = me.upLim; //use for resetting the upLim after each round
 
	//goes on forever until the user chooses to exit the game
	for (int x = 1; stop == 1; x ++){

	    //resets upLim, lowLim and ctr
	    me.lowLim = 1;
	    me.ctr =0;
	    me.upLim = temp;

	    //a different random number for each round
	    me.num = (int)((Math.random()*me.upLim) +1); 

	    //the game starts
	    System.out.println( "\nGuess a number from 1-"+me.upLim+": ");
	    int input = Keyboard.readInt();

	    for (int i = 1; i > 0; i ++){
		
		//make sure the user input an integer within the range [lowLim, upLim]
		if (input < me.lowLim || input > me.upLim ){
		    System.out.println("Wrong value! Try again! Guess a number from "+ me.lowLim + "-" + me.upLim +": ");
		    input = Keyboard.readInt();
		}

		//if the user guess the wrong number
		else if (me.lowOrHigh(input) == false){
		    System.out.println(me.message);
		    System.out.println("Guess a number from "+ me.lowLim + "-" + me.upLim +": ");
		    input = Keyboard.readInt();
		}

		//if the user guess the right number
		else{ 
		    System.out.println(me.message);
		    if (me.ctr < me.bestTry){  
			me.bestTry = me.ctr;
			System.out.println("YOU JUST BROKE YOUR RECORD!");
		    }
		    System.out.println("Your current best is: " + me.bestTry + " guesses! \n");
		    System.out.println("Do you want to play another round?");
		    System.out.println("1.Yes\n2.No");
		    stop = Keyboard.readInt();

		    //if the user input something other than 1 or 2: the game ends
		    if (stop != 1 && stop != 2){
			stop = 2;
			System.out.println("The game is over because you have just enter something other than 1 or 2.");
		    }
		    break; //end one round
		}
		
	    }
	    
	}
		 
    }//end main
    
}//end class
