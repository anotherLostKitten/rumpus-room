/*
Jack Cruse
APCS pd1
Hw38 -- Arrays of Arrays
2016-12-1
*/

// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArrayJCM {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    {
	for (int x = 0; x < a.length; x += 1) {//goes through each row in a
	    for (int y = 0; y < a[x].length - 1; y += 1) {// prints every element in a[x] except last on same line
		System.out.print(a[x][y]);
        }
	    System.out.println(a[x][a[x].length - 1]);//prints last element and starts a new line
	}
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    {
	for (int[] b: a) {//b reflects value of elements in a
	    for (int c: b) {// c does above with b
		System.out.print(c);//print each c in b
	    }
	    System.out.println();//start new line
	}	
    }


    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a )
    {
	int sum = 0;

	for (int x = 0; x < a.length; x += 1) {//loop through each row
	    sum += sumRow(x, a);//add sum--using a for loop--of each row to var sum
	}
	return sum;
    }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    {
	int sum = 0;

	for (int x = 0; x < m.length; x += 1) {//loop through each row
	    sum += sumRow2(x, m);//add sum--using a foreach loop--of each row to var sum
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
    {
	int sum = 0;
	
	for (int x = 0; x < a[r].length; x += 1) {//use for loop to loop through the elements of a[r]
	    sum += a[r][x];//add specifc element to var sum
	}
	return sum;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) 
    {
	int sum = 0;

	for (int x: m[r]) {//use foreach loop to take on the value of each element in m[r]
	    sum += x;//add value of each element to sum
	}
	return sum;
    }


    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) 
    {
	int sum = 0;

	for (int x = 0; x < m.length; x += 1) {//loop through each row of m
	    if (m[x].length > c) {//make sure that row c exists
		sum += m[x][c];//add value in row c to sum
	    }
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
	System.out.print("testing sumCol...\n");
	System.out.println("sum col 0 m1 : " + sumCol(0, m1));//0
	System.out.println("sum col 1 m1 : " + sumCol(1, m1));//0
	System.out.println("sum col 0 m2 : " + sumCol(0, m2));//5
	System.out.println("sum col 1 m2 : " + sumCol(1, m2));//9
	System.out.println("sum col 2 m2 : " + sumCol(2, m2));//13
	System.out.println("sum col 0 m3 : " + sumCol(0, m3));//7
	System.out.println("sum col 1 m3 : " + sumCol(1, m3));//9
	System.out.println("sum col 2 m3 : " + sumCol(2, m3));//5
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }

}//end class TwoDimArray
