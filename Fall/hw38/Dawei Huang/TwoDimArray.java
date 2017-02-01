//Dawei Huang
//Due: 12/01/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#38 -- Arrays of Arrays

// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArray {
    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		String printLine = "";
		for(int i = 0; i < a.length; i += 1){
			for (int x = 0; x < a[i].length; x +=1){
				printLine += a[i][x] + "\t";
			}
			System.out.println(printLine);
			printLine = "";
		}
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		String printLine = "";
		for (int[] b: a){
			for (int x : b){
				printLine += x + "\t";
			}
			System.out.println(printLine);
			printLine = "";
		}
    }


    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a )
    { 
	/* YOUR IMPLEMENTATION HERE */
		int summation = 0;
		for (int[] b: a){
			for (int x : b){
				summation += x;
			}
		}
		return summation;
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		int summation = 0;
		for (int[] x : m){
			summation += sumRow(x);
		}
		return summation;
    }

	//helper function sumRow referanced in previous method
	//sumRow method finds the sum of iterables in an int array
	private static int sumRow(int [] arr){
		int summation = 0;
		for (int x: arr){
			summation += x;
		}
		return summation;
	}

    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		int summation = 0;
		for(int i = 0; i < a[r].length; i+=1){
			summation += a[r][i];
		}
		return summation;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		int summation = 0;
		for (int x: m[r]){
			summation += x;
		}
		return summation;
    }


    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		int summation = 0;
		for(int[] x : m){
			summation += x[c];
		}
		return summation;
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
    }

}//end class TwoDimArray
