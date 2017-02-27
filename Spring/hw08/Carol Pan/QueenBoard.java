//Carol Pan
//APCS2 pd05
//HW08 - [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2017-02-20


/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * 1. Place down a queen in a column such that it will not be threatened
     * 2. Look at the next colum:
     *     - if possible, place down the queen in that column such that it will not be threatened by any other queen. Repeat step 2
     *     - if not, go back to the column previous
     * 3. If al queens are on the board, return true.
     * 4. If there are no other combinations, return false.
     */
    public boolean solve()
    {
	return solveH(0);//starting at the first column
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	//find the possible placement of Q in the column
	for (int r = 0; r < _board.length; r++){
	    //if the space is available
	    if (_board[r][col] == 0){
		//place down a queen
		addQueen(r,col);
		//if at the last column
		if (col == _board.length - 1){
		    //hurray it's done!
		    return true;
		}
		//if not at the last column
		else if (solveH(col + 1)){//but it works later on
		    //hurray it's done!
		    return true;
		}
		else{//oh, the later columns don't work out
		    removeQueen(r,col);//backtrack
		}
	    }
	}
	return false;//looks like it didn't work out...
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	solve();
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] == 1){
		    ans += "Q\t";
		    //ans += "Q|"; //this is personally a lot easier to see
		}
		else {
		    ans += "_\t";
		    //ans += "_|";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: valid row, and valid column
     * postcondition: 
     *    if the row and column is not available: return false
     *    else the inputted row and column now has a 1: return true
     */
    private boolean addQueen(int row, int col)
    {
	// if there is a queen (1),
	// or the space is in the line of attack (negs)
	if(_board[row][col] != 0){
	    return false; //cannot place
	}

	// if that a perfectly nice place, thank you
	_board[row][col] = 1;

	// tracking the warpath of the queen
	int offset = 1;

	// without exceeding the board
	while(col+offset < _board[row].length) {
	    // subtract one from all the columns directly right
	    _board[row][col+offset]--;

	    // subtract one from the upper right diagonal
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    //subtract one from the lower left diagonal
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // next iteration
	    offset++;
	}
	return true;// it is done
    }


    /***
     * <General description>
     * precondition: valid row, valid column
     * postcondition: 
          if there is no queen to remove: return false
	  if there is a queen to remove:
	       remove it
	       remove its warpath
	       return true
     */
    private boolean removeQueen(int row, int col)
    {
	// if there isn't a queen at the spot
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// remove the queen
	int offset = 1;	        // track its former warpath

	// while within the boundaries of the board
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    //next iteration
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: _board is filled completely
     * postcondition: returns a String rendition of the grid
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	System.out.println(b);
	b.addQueen(2,0);// this would work too. The methods act as if previous
	//columns are guaranteed to not be called on again.
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);

	//solve testers: they work
        QueenBoard cuatro = new QueenBoard(4);
	cuatro.printSolution();
	QueenBoard cinco = new QueenBoard(5);
	cinco.printSolution();
	QueenBoard ocho = new QueenBoard(8);
	ocho.printSolution();
    }//end main()
    
}//end class
