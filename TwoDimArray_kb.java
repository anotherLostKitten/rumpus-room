/* Kevin Bao
   APCS1 pd1
   HW38 -- Arrays of Arrays
   2016-12-1 */

public class TwoDimArray_kb {
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) {
	for (int row = 0 ; row < a.length ; row += 1) {
	    for (int col = 0 ; col < a[row].length ; col += 1) {
		System.out.print(a[row][col]);
	    }
	    System.out.print("\n");
	}
    }
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) {
	for (int[] row : a) {
	    for (int col : row) {
	        System.out.print(col);
	    }
	    System.out.print("\n");
	}
    }
    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a ) {
	int ans = 0;
	for (int[] row : a) {
	    for (int col : row) {
	        ans += col;
	    }
	}
	return ans;
    }
    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) {
	int ans = 0;
	for (int x = 0 ; x < m.length ; x += 1) {
	    ans += sumRow(x , m);
	}
	return ans;
    }
    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) {
	int ans = 0;
	for (int x = 0 ; x < a[r].length ; x += 1) {
	    ans += a[r][x];
	}
	return ans;
    }
    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) {
	int ans = 0;
	for (int element : m[r]) {
	    ans += element;
	}
	return ans;
    }
    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) {
	int ans = 0;
	for (int[] row : m) {
	    if (row.length - 1 < c) {
		ans += 0;
	    }
	    else{
		ans += row[c];
	    }
	}
	return ans;
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
	System.out.println("sum columns m1 : " + sumCol(1 , m1));
	System.out.println("sum columns m2 : " + sumCol(1 , m2));
	System.out.println("sum columns m3 : " + sumCol(1 , m3));
    }
}//end class TwoDimArray
