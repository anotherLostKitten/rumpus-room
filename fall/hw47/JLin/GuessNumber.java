/* Jeffrey Lin
 * APCS1 period 01
 * HW47 -- Keep Guessing
 * 2016-12-16
 */

import cs1.Keyboard;

public class GuessNumber {
    private int min = 1;
    private int max = 100;
    private int random = min + (int) (Math.random() * (max - min + 1));
    private int guess;
    private int turns;

    public void getGuess() {
        while ( true ) {
            System.out.print("Guess a number from " + min + " to " + max + ": ");

            int input = Keyboard.readInt();

            if ( input >= min && input <= max ) {
                guess = input;
                turns++;
                return;
            }

            System.out.println("Whoops, I didn't get that.");
        }
    }

    public boolean checkGuess() {
        if ( guess == random ) {
            if ( turns == 1 ) {
                System.out.println("Correct! It took 1 guess.");
            } else {
                System.out.println("Correct! It took " + turns + " guesses.");
            }

            return true;
        }

        String s = "";

        if ( guess > random ) {
            s = "high";
            max = guess - 1;
        } else {
            s = "low";
            min = guess + 1;
        }

        System.out.println("Too " + s + ", try again...");
        return false;
    }

    public static void main(String[] args) {
        GuessNumber Game = new GuessNumber();

        while ( true ) {
            Game.getGuess();

            if ( Game.checkGuess() ) {
                break;
            }
        }
    }
}

