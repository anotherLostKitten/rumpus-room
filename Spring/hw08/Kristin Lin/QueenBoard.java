//Kristin Lin
//APCS2 pd01
//HW#08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2017-02-27

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

    //counter for solutions
    private int solutions;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
      _board = new int[size][size];
      solutions = 0;
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * Calls solveH(0), which is the first case. A FOR loop is used to go down 
     * the possible positions in the column. If there is a position possible, 
     * then, the path beyond that position is examined, solveH(col++). This will
     * run a recursive loop, until it reaches the base case, which is an 
     * available position in the last column (which means the path was clear). 
     * If the path was not clear, meaning there was a column with no available 
     * space, then solveH(col++) will return false, and instead, the algo will 
     * remove the last queen and continue. The algo either finds a clear path
     * and returns true, or runs through all possible paths and returns false.
     */
    public boolean solve()
    {
      //finds all solutions and runs solve to determine if it's true or false
      printAll(0);
      boolean result = solveH(0);
      System.out.println(result + "\n");
      System.out.println("Number of solutions: " + solutions + "\n");
      return result; //then returns solve's result
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
      //it goes through the entire column for possible positions
      for (int x = 0; x < _board.length; x++) {
          //if there is a possible position,
          if (addQueen(x, col)) {
              //and this is the last column in the board, solution is found
              if(col == _board[0].length - 1) {
                  return true;
              } else { 
                  //otherwise, you must see what lies beyond this path.
                  if (solveH(col+1)) {
                      //if the path is good, you have the solution
                      return true; 
                  } else {
                      //if the path was bad, then you have to backtrack
                      removeQueen(x, col);
                  }
              }
          }
      }
      //after examining every possibility without luck, you can say its false
      return false;
    }

    /**
     * printAll is necessary because solve cannot find all solutions without 
     * return false, for to go through all possible solutions, returning true 
     * will tell the mechanism to stop because a solution is found. Therefore,
     * only false can be returned. This method was created so solve will 
     * return true, but all solutions can still be printed.
     */
    public boolean printAll(int col) {
        //same process as solveH()
        for (int x = 0; x < _board.length; x++) {
             if (addQueen(x, col)) {
                //if you've reached the last column, and there is a free space,
                //you have a solution. 
                if(col == _board[0].length - 1) {
                    printSolution(); //print the solution
                    solutions++;
                    removeQueen(x, col); //then carry on as if nothing happened
                } else { 
                    //looking at the path beyond will always be false
                    if (printAll(col+1) == false) {
                        removeQueen(x, col);
                    }
                }
             }
        }
        //after examining everything, false is returned
        return false;
  }

    //print a valid placement of n queens
    public void printSolution()
    {
      /** Print board, a la toString...
          Except:
          all negs and 0's replaced with underscore
          all 1's replaced with 'Q'
      */

      //same method as toString, but instead, number is examined and 
      //corresponding symbol is added
      String ans = "";
      for( int r = 0; r < _board.length; r++ ) {
          for( int c = 0; c < _board[0].length; c++ ) {
              if (_board[r][c] == 1) {
                  ans += "Q"+"\t";
              } else {
                  ans += "_" + "\t";
              }
          }
          ans += "\n";
      }
      System.out.println(ans);

    }



    //================= YE OLDE SEPARATOR =================

    /***
     * If there is a queen on the indicated position or there cannot be a queen 
     * in indicated position, then returns false. Otherwise, the position is 
     * marked 1, and the rest of the positions in that row and the two diagonals
     * (on the right side of the current column) are subtracted by 1. 
     *
     * precondition: Indicated position has an integer less than or equal to 1
     * postcondition: Indicated position has integer 1, or a negative number. 
     * If indicated position has integer 1, then positions that now cannot be 
     * taken that exist in the columns to the right of the indicated position
     * are marked down by one. Returns false if indicated position is set to 1,
     * otherwise false.
     */
    private boolean addQueen(int row, int col)
    {
      //if no queens are allowed, return false
      if(_board[row][col] != 0){
          return false;
      }

      //place queen on indicated position
      _board[row][col] = 1;

      //indicating how many columns to the right we are examining
      int offset = 1;

      //keeping algo in bounds of board
      while(col+offset < _board[row].length) {
          //marking other positions in row down by 1
          _board[row][col+offset]--;

          //marking other positions in the two columns down by 1
          if( row - offset >= 0 ) {
              _board[row-offset][col+offset]--;
          }
          if( row + offset < _board.length ) {
              _board[row+offset][col+offset]--;
          }
          //looking at next column to the right
          offset++;
      }
      return true;
    }


    /***
     * If there is not a queen present in indicated position, return false. 
     * Otherwise, set the indicated position to 0 again, and increase the 
     * numbers of each position that lies on the row and the diagonals of the 
     * to the right of the indicated position.
     *
     * precondition: Indicated position has number less than or equal to 1
     * postcondition: Returns false if position had number 1. Otherwise, 
     * corresponding positions that lie to the right on the row and the 
     * diagonals are set to 0 and true is returned.
     */
    private boolean removeQueen(int row, int col)
    {
      //if there was no queen to remove, return false
      if ( _board[row][col] != 1 ) {
          return false;
      }
      _board[row][col] = 0;	//remove the queen
      int offset = 1;	        //indicate how far to the right we're looking

      //while in bounds of the board, increase each position that lies on the
      //diagonals or row to the right by 1
      while( col+offset < _board[row].length ) {
          _board[row][col+offset]++;
          if( row - offset >= 0 ) {
              _board[row-offset][col+offset]++;
          }
          if( row + offset < _board.length ) {
              _board[row+offset][col+offset]++;
          }
          offset++;
      }
      return true;
    }


    /***
     * Create a string, and add integers in board line by line. Return string
     * with integers in n by n formation.
     *
     * precondition: Nothing
     * postcondition: String with integers indicating queen positions in n by 
     * n formation
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
      /*=======================================
      QueenBoard b = new QueenBoard(5);
            System.out.println(b);
      b.addQueen(3,0);
      b.addQueen(0,1);
      System.out.println(b);
      b.removeQueen(3,0);
            System.out.println(b);
      ==============================================*/

      QueenBoard two = new QueenBoard(2);
      System.out.println("Solution for 2x2 board: \n");
      two.solve();
      QueenBoard three = new QueenBoard(3);
      System.out.println("Solution for 3x3 board: \n");
      three.solve();
      QueenBoard four = new QueenBoard(4);
      System.out.println("Solution for 4x4 board: \n");
      four.solve();
      QueenBoard five = new QueenBoard(5);
      System.out.println("Solution for 5x5 board: \n");
      five.solve();
      QueenBoard six = new QueenBoard(6);
      System.out.println("Solution for 6x6 board: \n");
      six.solve();
      QueenBoard seven = new QueenBoard(7);
      System.out.println("Solution for 7x7 board: \n");
      seven.solve();
      QueenBoard eight = new QueenBoard(8);
      System.out.println("Solution for 8x8 board: \n");
      eight.solve();



    }//end main()
    
}//end class
