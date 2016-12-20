/* Gilvir Gill
 * APCS1 P1
 * 2016-12-16
 * HW#47 -- Keep Guessing
*/


import cs1.Keyboard;
public class GuessNumber {

    //instance variables
    boolean _isRecursive;
    int _correct;
    //boundds (if recursive only important for initial call, else are iterated through)
    int _lower;
    int _upper;
    //THIS IS ONLY EVER USED BY THE ITERATIVE APPROACH
    int _count;
    //constructors
    //DEFAULT CONSTRUCTOR FEEDS INTO LOW/HIGH CONSTRUCTOR
    public GuessNumber() {
        this(1, 100);
    }
    public GuessNumber(int b1, int b2) {
        _lower = Math.min(b1,b2);
        _upper = Math.max(b1,b2);
        _correct = _lower + (int) (Math.random() * (_upper-_lower));
        _isRecursive = true;
    }
    public GuessNumber(int b1, int b2, boolean bool) {
        this(b1,b2);
        _isRecursive = bool;
    }
    public int userGuess() {
        System.out.print("Your number: ");
        return Keyboard.readInt();
    }
    //this requires no instance variables except _correct
    //This is a single round that returns whether the attempt was successful or not, for a recursive approacj
    public int GameR(Integer guess, int l, int u) {
        int compStat = guess.compareTo(_correct);
        //base case: number is equally
        if (compStat == 0) {
            System.out.println(+ _correct + ", the number was.");
            return 1;
            //code terminates and returns 0 because on this round it took 0 tries
        }
        //redefine upper and lower bounds
        //if the guess is higher than the correct, then redefine the upper bound to it:
        if (compStat > 0) {
            //set u equal to guess if the guess was more than the correct but in bounds
            u = Math.min(guess, u);
        }
        //if the guess is less, redefine the lower bound to the guess if its useful to
        else {
            l = Math.max(guess, l);

        }
        System.out.println(guess + ", the number is not.");
        System.out.println("between " + l + " and " + u + ", it is.");
        //recursively run another round of the game w/ new bounds
        return 1 + GameR(userGuess(), l, u);
    }
    public void gameW() {
        int guess = userGuess();
        _count = 1;
        //this loop recalls userGuess() every time after it finishes running
        while (guess != _correct) {
            System.out.println(guess + ", the number is not.");
            if (guess > _correct) {
                _upper = Math.min(guess, _upper);
            }
            else {
                _lower = Math.max(guess, _lower);
            }
            _count+= 1;
            System.out.println("between " + _lower + " and " + _upper + ", it is.");
            guess = userGuess();

        }
        System.out.println(_count + "  attempts, it took");

    }
    public void play() {
        //if the playmode is recursive, which is the default, then:
        System.out.println("Choose a number between " + _lower + " and " + _upper + ", you shall.");
        if (_isRecursive) {
            // run the recursive method and used the returned int value to show many attempts it took
            System.out.println(GameR(userGuess(), _lower, _upper) + " attempts, it took");
        }
        else {
            gameW();
        }
    }



    //MAIN METHOD:
    public static void main(String[] args) {
        for (int n = 100; n < 100000; n*=100) {
            //recursive
            (new GuessNumber(1,n, true)).play();
            //ITERATIVE
            (new GuessNumber(1,n*10, false)).play();
        }
        System.out.println("Beat the game, you have");
    }
}
