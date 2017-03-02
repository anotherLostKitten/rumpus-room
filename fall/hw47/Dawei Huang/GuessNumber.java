//Dawei Huang
//APCS1 pd4
//HW47 -- Keep Guessing 
//12/19/16

import cs1.Keyboard;
import java.util.ArrayList;

public class GuessNumber{
	
	//class variables
    private ArrayList<Integer> _data;
    private int targetInt;
	private int guessInt;
	private int upperBound;
	private int lowerBound;
	private boolean formatValid;

	//main method
    public static void main(String[] args){
		//create instance of class GuessNumber
		GuessNumber game = new GuessNumber();
		System.out.println("Welcome to the Guess-a-Number Game\n");
		
		//generate random number
		game.genRandomNumber();
		System.out.println("A random integer between 1 and 100 inclusive has been generated.");
		
		//loop if the guessInt is not equal to the targetInt
		while (game.guessInt != game.targetInt){
			System.out.println("\nEnter guess between " + game.lowerBound + "-" + game.upperBound + ":");
			
			//interface for user to insert guess
			try {
					game.guessInt = Integer.parseInt(cs1.Keyboard.readWord());
				}
				
			//catch invalid formatting
			catch (Exception e) {
				System.out.println("You had entered an invalid format. Please try again!");
				game.formatValid = true;
			}
			
			//checks to see if the numbers are within range
			if (game.guessInt > 100 || game.guessInt < 1){
				if (game.formatValid == false){
					System.out.println("You had entered an invalid range. Please try again.");
				}
				else{
					game.formatValid = false;
				}
			}
			
			//checking algorithm below runs if prior checks are passed. Sets upper and lower bounds depending
			//on the user input in order to facilitate the user's guess.
			else{
				game._data.add(game.guessInt);
				if (game.guessInt > game.targetInt){
					System.out.println("The number entered it too high. Please try again.");
					if (game.upperBound > game.guessInt){
						game.upperBound = game.guessInt;
					}
				}
				else if (game.guessInt < game.targetInt){
					System.out.println("The number entered it too low. Please try again.");
					if (game.lowerBound < game.guessInt){
						game.lowerBound = game.guessInt;
					}
				}
			}
		}
		System.out.println("\nCongratulations, you got the correct number in " + game._data.size() + " tries! Whether this is good or bad is up to you!!!");
	}
	
	//default constructor
	public GuessNumber() {
		_data = new ArrayList<Integer>();
		targetInt = (int)(Math.random() * 100 + 1);
		upperBound = 100;
		lowerBound = 1;
    }
	
	//generates random number
    public void genRandomNumber(){
		targetInt = (int)(Math.random() * 100 + 1);
	}
}
