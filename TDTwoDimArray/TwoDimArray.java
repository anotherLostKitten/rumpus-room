/*Truc Dao
APCS1 pd4
HW38 -- Arrays of Arrays
2016-12-02 */

// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    { 
	for (int row = 0; row < a.length; row += 1){
	    for (int col = 0; col < a[row].length; col += 1){
		System.out.print(a[row][col] + "\t");
	    }
	    System.out.println();//separates rows of numbers
	}
	System.out.println();//separates from next thing printed
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    { 
        for (int[] i : a){
	    for (int x : i){
		System.out.print(x + "\t");
	    }
	    System.out.println();//separates rows of numbers
	}
	System.out.println();//separates from next thing printed
    }


    //postcond: returns sum of all items in 2D integer array a
    //goes through each row and column and adds the number 
    public static int sum1( int[][] a )
    { 
        int sum = 0;
	for (int[] i : a){
	    for (int x : i){
		sum += x;
	    }
	}
	return sum;
    }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    //adds the sums of all the rows
    public static int sum2( int [][] m ) 
    { 
        int sum = 0;
	for (int index = 0; index < m.length; index += 1){
	    sum += sumRow(index , m);
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    //goes through the row and adds each number to sum
    public static int sumRow( int r, int[][] a ) 
    { 
	int sum = 0;
        for (int index = 0; index < a[r].length; index += 1){
	    sum += a[r][index];
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    //goes through the row and adds each number to sum
    public static int sumRow2( int r, int[][] m ) 
    { 
        int sum = 0;
	for (int x : m[r]){
	    sum += x;
	}
	return sum;
    }


    //postcond: returns sum of all items in column c of 2D integer array 
    //goes to each row and takes the number in each column to add to sum
    public static int sumCol( int c, int[][] m ) 
    { 
        int sum = 0;
	for (int row = 0; row < m.length; row += 1){
	    sum += m[row][c];
	}
	return sum;
    }


    public static void main( String [] args ) 
    {
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	print2(m1);
	print2(m2);
	print2(m3);
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
	System.out.println("sumRow m3R2 : " + sumRow(2, m3));
	System.out.println("sumRow2 m3R2 : " + sumRow2(2, m3));
	System.out.println("sumCol m3C0 : " + sumCol(0, m3));
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class TwoDimArray
